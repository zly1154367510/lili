package com.zly.service;

import com.zly.model.EUDataGridResult;
import com.zly.model.Item;

import java.util.List;

/**
 * Created by zly11 on 2018/4/29.
 */
public interface ItemService {

    List<Item> getItem(int page, int rows);
    long getItemNum();
    boolean addItem(Item item);
    Item getItemById(Long id);
    int delItemById(String id);
}
