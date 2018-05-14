package com.zly.dao;

import com.zly.model.ItemParamGroup;
import org.apache.ibatis.annotations.One;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface ItemParamGroupMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemParamGroup record);

    int insertSelective(ItemParamGroup record);

    ItemParamGroup selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemParamGroup record);

    int updateByPrimaryKey(ItemParamGroup record);

    @Select("select id,group_name as groupName,item_cat_id as itemCatId from tb_item_param_group where id=#{id}")
    ItemParamGroup findItemParamGroupById(Integer id);

    @Select("select id,group_name as groupName,item_cat_id as itemCatId from tb_item_param_group where item_cat_id = #{itemcatid}")
    @Results({
            @Result(column = "id",property = "itemParanKeyList",
            one = @One(select = "com.zly.dao.ItemParanKeyMapper.findAllItemParankeyByGroudId"))
    })
    List<ItemParamGroup> findItemParamGroupByItemCatId(Long itencatid);
}