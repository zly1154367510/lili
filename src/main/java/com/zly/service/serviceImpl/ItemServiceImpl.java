package com.zly.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.ItemMapper;
import com.zly.model.EUDataGridResult;
import com.zly.model.Item;
import com.zly.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by zly11 on 2018/4/29.
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemMapper itemMapper;

    @Override
    public List<Item> getItem(int page, int rows) {
        PageHelper.startPage(page,rows);
        return itemMapper.selectItem();
    }

    @Override
    public Item getItemById(Long id){
        return itemMapper.selectByPrimaryKey(id);
    }

    @Override
    public long getItemNum() {
        return itemMapper.selectItemNum();
    }

    @Override
    public boolean addItem(Item item) {
        item.setCreated(new Date());
        itemMapper.addItem(item);
        return false;
    }

    @Override
    public int delItemById(String id) {
        return itemMapper.delItemById(id);
    }
}
