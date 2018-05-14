package com.zly.dao;

import com.zly.model.ItemCat;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemCatMapper {
    int deleteByPrimaryKey(Long id);

    int insert(ItemCat record);

    int insertSelective(ItemCat record);

    ItemCat selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(ItemCat record);

    int updateByPrimaryKey(ItemCat record);
    //查询父节点
    @Select("select id,parent_id as parentId,name,is_parent as isParent from tb_item_cat where parent_id=0")
    List<ItemCat> getItemCatParent();

    @Select("select id,parent_id as parentId,name,is_parent as isParent from tb_item_cat where parent_id = #{id}")
    List<ItemCat> isLeatNode(long id);

    @Select("select name from tb_item_cat where parent_id=0")
    List<String> selectItemCatName();
}