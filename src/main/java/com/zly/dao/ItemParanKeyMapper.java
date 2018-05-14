package com.zly.dao;

import com.zly.model.ItemParam;
import com.zly.model.ItemParanKey;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ItemParanKeyMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(ItemParanKey record);

    int insertSelective(ItemParanKey record);

    ItemParanKey selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(ItemParanKey record);

    int updateByPrimaryKey(ItemParanKey record);

    @Select("select id,param_name as paramName,group_id as groupId from tb_item_param_key where group_id=#{groupId}")
//    @Results({
//            @Result(column = "id",property = "itemParamValue",
//            one = @One(select = "com.zly.dao.ItemParamValueMapper.findItemByParamId"))
//    })
    List<ItemParanKey> findAllItemParankeyByGroudId(Long groupId);

    @Select("select id,param_name as paramName,group_id as groupId from tb_item_param_key ")
    @Results({
            @Result(column = "groupId",property = "itemParamGroup",
            one = @One(select = "com.zly.dao.ItemParamGroupMapper.findItemParamGroupById"))
    })
    List<ItemParanKey> findAllKeyGroup(Integer itemId);


}