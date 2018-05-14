package com.zly.service;



import com.zly.model.Config;

import java.util.List;

/**
 * Created by zly11 on 2018/5/14.
 */
public interface ConfigService {

    List<Config> getConfig();

    int updateConfigById(String param,int id);

}
