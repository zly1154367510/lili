package com.zly.service;

import com.zly.model.User;

import java.util.List;

/**
 * Created by zly11 on 2018/4/28.
 */
public interface UserSercice {

    List<User> findAll(int pages,int size);

    int getItemNum();

    int banUser(Long userId,String reason);
}
