package com.zly.service.serviceImpl;

import com.zly.dao.ItemParamGroupMapper;
import com.zly.dao.ItemParamValueMapper;
import com.zly.dao.ItemParanKeyMapper;
import com.zly.model.ItemParam;
import com.zly.model.ItemParamGroup;
import com.zly.model.ItemParamValue;
import com.zly.model.ItemParanKey;
import com.zly.service.ItemParamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/3.
 */
@Service
public class ItemParamServiceImpl implements ItemParamService{

    @Autowired
    private ItemParamGroupMapper itemParamGroupMapper;

    @Autowired
    private ItemParamValueMapper itemParamValueMapper;



    @Override
    public List<ItemParamGroup> findAllKeyGroup(Long itemCatId){
       // System.out.println("这里是service接口");
        return itemParamGroupMapper.findItemParamGroupByItemCatId(itemCatId);
    }

    @Override
    public List<ItemParamValue> findItemParamValueByItemId(Long itemId) {
        return itemParamValueMapper.findItemParamValueByTimeId(itemId) ;
    }

    @Override
    public void updOrInsItemParam(Long paramKey, String paramValue,Long itemId) {
        if (itemParamValueMapper.findItemParamValueByTimeIdParamId(itemId,paramKey).size()==0){
            itemParamValueMapper.insertItemParamValue(itemId,paramKey,paramValue);
        }else{
            itemParamValueMapper.updateItemParamValue(itemId,paramKey,paramValue);
        }
    }
}
