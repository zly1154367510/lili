package com.zly.dao;

import com.zly.model.BanUser;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;

import java.util.Date;

public interface BanUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(BanUser record);

    int insertSelective(BanUser record);

    BanUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(BanUser record);

    int updateByPrimaryKey(BanUser record);

    @Insert("insert into tb_ban_user (id,user_id,ban_reason,ban_date) values (null,#{userId},#{banReason},#{banDate})")
    int insertByUserId(@Param("userId")Long userId, @Param("banReason")String banReason, @Param("banDate")Date banDate);
}