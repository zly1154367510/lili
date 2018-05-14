package com.zly.service.serviceImpl;

import com.zly.dao.ItemCatMapper;
import com.zly.model.ItemCat;
import com.zly.numStructure.ItemCatTree;
import com.zly.service.ItemCatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly11 on 2018/5/1.
 */
@Service
public class ItemCatServiceImpl implements ItemCatService {

    @Autowired
    private ItemCatMapper itemCatMapper;

    public List<ItemCat> getItemCatParen(){
        //获得第一层父节点
        List<ItemCat> oneParenList = itemCatMapper.getItemCatParent();
        List<ItemCat> oneParenList1 =  isLeaf(oneParenList);
        return oneParenList1;

    }


    private List<ItemCat> isLeaf(List<ItemCat> list){

        for (ItemCat ic :list){
            List<ItemCat> nodeList = itemCatMapper.isLeatNode(ic.getId());
            if (nodeList.size() != 0){
                //指针指向下一节点
                ic.setSubList(nodeList);
                isLeaf(nodeList);
            }
        }
        return list;
    }

    @Override
    public List<String> getItemCatName() {
        return itemCatMapper.selectItemCatName();
    }
}