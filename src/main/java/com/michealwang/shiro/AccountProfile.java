package com.michealwang.shiro;

import lombok.Data;

import java.io.Serializable;

/**
 * @author micheal.wang
 * @date 2020/7/23 22:13
 * @Email:wangmk13@163.com
 * @Description 登录成功之后返回的一个用户信息的载体
 */
@Data
public class AccountProfile implements Serializable {

    private Long id;

    private String username;

    private String avatar;

    private String email;

}
