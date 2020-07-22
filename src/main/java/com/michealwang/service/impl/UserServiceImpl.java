package com.michealwang.service.impl;

import com.michealwang.entity.User;
import com.michealwang.mapper.UserMapper;
import com.michealwang.service.UserService;
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
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
