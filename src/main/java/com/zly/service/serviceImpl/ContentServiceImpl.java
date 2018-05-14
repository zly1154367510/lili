package com.zly.service.serviceImpl;

import com.github.pagehelper.PageHelper;
import com.zly.dao.ContentMapper;
import com.zly.model.Content;
import com.zly.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/12.
 */
@Service
public class ContentServiceImpl implements ContentService {

    @Autowired
    private ContentMapper contentMapper;

    @Override
    public int addAdv(Content content) {
        return contentMapper.insert(content);
    }

    @Override
    public List<Content> findAllContent(int page) {
        PageHelper.startPage(page,5);
        return contentMapper.selectContent();
    }

    @Override
    public long findContentNum() {
        return contentMapper.selectContentNum();
    }

    @Override
    public int delItemById(String id) {
        return contentMapper.delContentById(id);
    }
}
