package com.zly.service.serviceImpl;

import com.zly.dao.ContentCategoryMapper;
import com.zly.model.ContentCategory;
import com.zly.service.ContentCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/12.
 */
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

    @Autowired
    private ContentCategoryMapper contentCategoryMapper;

    @Override
    public List<ContentCategory> findAllContentCategory() {
        return contentCategoryMapper.selectContentCategory();
    }
}
