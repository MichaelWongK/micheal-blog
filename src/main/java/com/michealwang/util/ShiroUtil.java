package com.michealwang.util;

import com.michealwang.shiro.AccountProfile;
import org.apache.shiro.SecurityUtils;

/**
 * @author micheal.wang
 * @date 2020/7/24 20:51
 * @Email:wangmk13@163.com
 * @Description
 */
public class ShiroUtil {

    public static AccountProfile getProfile() {
        return (AccountProfile) SecurityUtils.getSubject().getPrincipal();
    }
}
