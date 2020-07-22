package com.michealwang.service.impl;

import com.michealwang.entity.Blog;
import com.michealwang.mapper.BlogMapper;
import com.michealwang.service.BlogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author micheal.wang
 * @since 2020-07-23
 */
@Service
public class BlogServiceImpl extends ServiceImpl<BlogMapper, Blog> implements BlogService {

}
