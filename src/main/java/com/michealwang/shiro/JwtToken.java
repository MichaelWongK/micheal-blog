package com.michealwang.shiro;

import org.apache.shiro.authc.AuthenticationToken;

/**
 * @author micheal.wang
 * @date 2020/7/23 21:26
 * @Email:wangmk13@163.com
 * @Description
 */
public class JwtToken implements AuthenticationToken {

    private String token;

    public JwtToken(String jwt) {
        this.token = jwt;
    }

    @Override
    public Object getPrincipal() {
        return token;
    }

    @Override
    public Object getCredentials() {
        return token;
    }
}
