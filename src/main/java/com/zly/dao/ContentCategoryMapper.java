package com.zly.dao;

import com.zly.model.ContentCategory;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ContentCategoryMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ContentCategory record);

    int insertSelective(ContentCategory record);

    ContentCategory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ContentCategory record);

    int updateByPrimaryKey(ContentCategory record);

    @Select("select * from tb_content_category")
    List<ContentCategory> selectContentCategory();

    @Select("select id,name from tb_content_category where id=#{id}")
    ContentCategory selectContentCategoryById(Long id);
}