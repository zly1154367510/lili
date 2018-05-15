package com.zly.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.BanUserMapper;
import com.zly.dao.UserMapper;
import com.zly.model.BanUser;
import com.zly.model.User;
import com.zly.service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/4/28.
 */
@Service
public class UserServiceImpl implements UserSercice {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BanUserMapper banUserMapper;

    @Override
    public List<User> findAll(int page,int size) {
        PageHelper.startPage(page,size);
        return userMapper.selectUser();
    }

    @Override
    public int getItemNum() {
        return userMapper.selectUserItemNum();
    }

    @Override
    @Transactional
    public int banUser(Long userId, String reason) {
        System.out.println(reason);
        int i = userMapper.updateById(userId);
        int j = banUserMapper.insertByUserId(userId,reason,new Date());

        return j;
    }
}
