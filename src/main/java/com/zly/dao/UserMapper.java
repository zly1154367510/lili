package com.zly.dao;

import com.zly.model.User;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    @Select("select * from tb_user where is_ban='否'")
    List<User> selectUser();

    @Select("select count(*) from tb_user where is_ban='否'")
    int selectUserItemNum();

    @Update("update tb_user set is_ban='是' where id=#{id}")
    int updateById(Long id);

    @Select("select * from tb_user where username=#{username}")
    List<User> selectByUsername(String username);
}