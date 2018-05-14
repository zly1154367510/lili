package com.zly.dao;

import com.zly.model.Item;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.InsertProvider;
import org.apache.ibatis.annotations.Select;
import org.springframework.http.converter.StringHttpMessageConverter;

import java.util.Date;
import java.util.List;

public interface ItemMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    @Select("select * from tb_item where id =#{id}")
    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    @Select("select id,title,sell_point as sellPoint,price,num,created,updated from tb_item")
    List<Item> selectItem();

    @Select("select count(*) from tb_item")
    long selectItemNum();

    @InsertProvider(type = sqlFactory.class,method = "addItem")
    void addItem(Item item);

    int updateByPrimaryKey(Item record);

    @Delete("delete from tb_item where id = #{id}")
    int delItemById(String id);

    class sqlFactory{
        public String addItem(Item item){

            String sql = "insert into tb_item (id,title,sell_point,price,num,image,cid,status,created,updated)values(null,#{title},#{sellPoint},#{price},#{num},#{image},#{cid},1,#{created},null)";
            return sql;
        }
    }
}