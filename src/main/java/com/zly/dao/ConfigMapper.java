package com.zly.dao;

import com.zly.model.Config;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface ConfigMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Config record);

    int insertSelective(Config record);

    Config selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Config record);

    int updateByPrimaryKey(Config record);

    @Select("select id,config_name as configName,config_value as configValue from tb_config ")
    List<Config> selectConfig();

    @Update("update tb_config set config_value=#{param} where id =#{id}")
    int updateConfigById(@Param("param") String param,@Param("id") int id);
}