package com.zly.service.serviceImpl;

import com.zly.dao.UserMapper;
import com.zly.model.User;
import com.zly.service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by zly11 on 2018/4/28.
 */
@Service
public class UserServiceImpl implements UserSercice {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(String username) {
        return userMapper.selectByUsernamePassword();
    }
}
