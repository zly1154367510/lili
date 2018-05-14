package com.zly.dao;

import com.zly.model.Content;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ContentMapper {
    int deleteByPrimaryKey(Long id);



    int insertSelective(Content record);

    Content selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Content record);

    int updateByPrimaryKeyWithBLOBs(Content record);

    int updateByPrimaryKey(Content record);

    @Insert("insert into tb_content(id,category_id,title,url,pic) values(null,#{categoryId},#{title},#{url},#{pic})")
    int insert(Content content);

    @Select("select id,title,category_id as categoryId,url,pic from tb_content")
    @Results({
            @Result(column = "categoryId",property = "contentCategory",
            one = @One(select = "com.zly.dao.ContentCategoryMapper.selectContentCategoryById"))
    })
    List<Content> selectContent();

    @Select("select count(*) from tb_content")
    long selectContentNum();

    @Delete("delete from tb_content where id = #{id}")
    int delContentById(String id);
}