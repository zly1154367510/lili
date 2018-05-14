package com.zly.dao;

import com.zly.model.ItemParamValue;
import com.zly.model.ItemParamValueKey;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface ItemParamValueMapper {
    int deleteByPrimaryKey(ItemParamValueKey key);

    int insert(ItemParamValue record);

    int insertSelective(ItemParamValue record);

    ItemParamValue selectByPrimaryKey(ItemParamValueKey key);

    int updateByPrimaryKeySelective(ItemParamValue record);

    int updateByPrimaryKey(ItemParamValue record);

    @Select("select param_id as paramId,param_value as paramValue from tb_item_param_value where param_id=#{paramId}")
    ItemParamValue findItemByParamId(Long paramId);

    @Select("select param_id as paramId,param_value as paramValue from tb_item_param_value where item_id=#{itemId} ")
    List<ItemParamValue> findItemParamValueByTimeId(Long itemId);

    @Select("select param_id as paramId,param_value as paramValue from tb_item_param_value where item_id=#{itemId} and param_id=#{paramId}")
    List<ItemParamValue> findItemParamValueByTimeIdParamId(@Param("itemId")Long itemId,@Param("paramId")Long paramId);

    @Insert("insert into tb_item_param_value values (#{itemId},#{paramId},#{paramValue})")
    void insertItemParamValue(@Param("itemId") Long itemId, @Param("paramId") Long paramId, @Param("paramValue") String paramValue);

    @Update("update tb_item_param_value set param_value=#{paramValue} where item_id=#{itemId} and param_id=#{paramId}")
    void updateItemParamValue(@Param("itemId") Long itemId, @Param("paramId") Long paramId, @Param("paramValue") String paramValue);
}