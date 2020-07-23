package com.michealwang.controller;


import com.michealwang.common.lang.ResultJson;
import com.michealwang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author micheal.wang
 * @since 2020-07-23
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public ResultJson index() {
        return ResultJson.success(userService.getById(1L));
    }

}
