package com.michealwang.controller;


import cn.hutool.core.bean.BeanUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.michealwang.common.lang.ResultJson;
import com.michealwang.entity.Blog;
import com.michealwang.service.BlogService;
import com.michealwang.util.ShiroUtil;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresAuthentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author micheal.wang
 * @since 2020-07-23
 */
@RestController
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/blogs")
    public ResultJson  list(@RequestParam(defaultValue = "1") Integer currentPage) {
        Page page = new Page(currentPage, 5);
        IPage pageData = blogService.page(page, new QueryWrapper<Blog>().orderByDesc("createDate"));
        return ResultJson.success(pageData);
    }

    @GetMapping("/blog/{id}")
    public ResultJson detail(@PathVariable(name = "id") String id) {
        Blog blog = blogService.getById(id);
        Assert.notNull(blog, "该博客已被删除");

        return ResultJson.success(blog);
    }

    @RequiresAuthentication
    @PostMapping("/blog/edit")
    public ResultJson edit(@Validated @RequestBody Blog blog) {

        Blog temp = null;

        blog.setUpdateDate(LocalDateTime.now());
        if (!StringUtils.isEmpty(blog.getId())) {
            temp = blogService.getById(blog.getId());
            // 只能编辑自己的文章
            Assert.isTrue(temp.getUserId() == ShiroUtil.getProfile().getId(), "没有权限编辑");
        } else {
            temp = new Blog();
            temp.setUserId(ShiroUtil.getProfile().getId());
            temp.setCreateDate(blog.getUpdateDate());
            temp.setStatus(0);
        }

        BeanUtil.copyProperties(blog, temp, "id", "userId", "createDate", "status");
        blogService.saveOrUpdate(temp);

        return ResultJson.success(temp);
    }
}
