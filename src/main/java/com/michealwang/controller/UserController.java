package com.michealwang.controller;


import com.michealwang.common.lang.ResultJson;
import com.michealwang.entity.User;
import com.michealwang.service.UserService;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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

    @RequiresAuthentication
    @GetMapping("/index")
    public ResultJson index() {
        return ResultJson.success(userService.getById(1L));
    }

    @PostMapping("/save")
    public ResultJson save(@Validated @RequestBody User user) {
        return ResultJson.success(user);
    }

}
