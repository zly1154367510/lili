package com.zly.service.serviceImpl;

import com.sun.webpane.platform.ConfigManager;
import com.zly.dao.ConfigMapper;
import com.zly.model.Config;
import com.zly.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by zly11 on 2018/5/14.
 */
@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public List<Config> getConfig() {
        return configMapper.selectConfig();
    }

    @Override
    public int updateConfigById(String param, int id) {
        return configMapper.updateConfigById(param,id);
    }
}


