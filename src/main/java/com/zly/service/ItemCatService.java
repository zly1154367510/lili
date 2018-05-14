package com.zly.service;

import com.zly.model.ItemCat;

import java.util.List;

/**
 * Created by zly11 on 2018/5/1.
 */
public interface ItemCatService {

    List<ItemCat> getItemCatParen();
    List<String> getItemCatName();
}
