package com.zly.service;

import com.zly.model.Content;

import java.util.List;

/**
 * Created by zly11 on 2018/5/12.
 */
public interface ContentService {

    int addAdv(Content content);
    List<Content> findAllContent(int page);
    long findContentNum();
    int delItemById(String id);
}
