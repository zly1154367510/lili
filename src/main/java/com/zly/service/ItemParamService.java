package com.zly.service;

import com.zly.model.ItemParam;
import com.zly.model.ItemParamGroup;
import com.zly.model.ItemParamValue;
import com.zly.model.ItemParanKey;

import java.util.List;

/**
 * Created by zly11 on 2018/5/3.
 */
public interface ItemParamService {


    List<ItemParamGroup> findAllKeyGroup(Long itemCatId);

    List<ItemParamValue> findItemParamValueByItemId(Long itemId);

    void updOrInsItemParam(Long paramKey,String paramValue,Long itemId);
}
