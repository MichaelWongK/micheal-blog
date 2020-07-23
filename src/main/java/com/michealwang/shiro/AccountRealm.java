package com.michealwang.shiro;

import cn.hutool.core.bean.BeanUtil;
import com.michealwang.entity.User;
import com.michealwang.service.UserService;
import com.michealwang.util.JwtUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author micheal.wang
 * @date 2020/7/23 20:09
 * @Email:wangmk13@163.com
 * @Description AccountRealm是shiro进行登录或者权限校验的逻辑所在
 */
@Component
public class AccountRealm extends AuthorizingRealm {

    @Autowired
    private JwtUtils jwtUtils;
    @Autowired
    private UserService userService;

    @Override
    public boolean supports(AuthenticationToken token) {
        return token instanceof JwtToken;
    }

    /*
     * 权限校验
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }

    /*
     * 登录认证校验
     * 通过jwt获取到用户信息，判断用户的状态，最后异常就抛出对应的异常信息，
     * 否则封装成SimpleAuthenticationInfo返回给shiro
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        JwtToken jwtToken = (JwtToken) token;

        String userId = jwtUtils.getClaimByToken((String) jwtToken.getPrincipal()).getSubject();

        User user = userService.getById(userId);
        if (user == null) {
            throw new UnknownAccountException("账户不存在");
        }

        if (user.getStatus() == -1) {
            throw new LockedAccountException("账户已被锁定");
        }

        AccountProfile profile = new AccountProfile();
        BeanUtil.copyProperties(user, profile);

        System.out.println("------------------------");
        return new SimpleAuthenticationInfo(profile, jwtToken.getCredentials(), getName());
    }
}
