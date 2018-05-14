package com.zly.dao;

import com.zly.model.User;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    User selectByUsernamePassword();
    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);
}