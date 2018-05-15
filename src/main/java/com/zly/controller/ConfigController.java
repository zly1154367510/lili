package com.zly.controller;

import com.sun.org.apache.xpath.internal.operations.Mod;
import com.zly.model.Config;
import com.zly.service.ConfigService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by zly11 on 2018/5/13.
 */
@Controller
public class ConfigController {

    @Autowired
    private ConfigService configService;

    @RequestMapping("/config")
    public String getConfig(Model model){
        List<Config> list = configService.getConfig();
        model.addAttribute("list",list);
        model.addAttribute("listLen",list.size());
        model.addAttribute("config",new Config());
        return "config/config";
    }

    @RequestMapping("/editConfigDo")
    public String EditConifgDo(HttpServletRequest request,Model model){
        int len = Integer.parseInt(request.getParameter("paramNum"));
        int SuccessNum = 0;
        for (int i=1;i<=len;i++){
            String configValue = request.getParameter(i+"");
            if (configService.updateConfigById(configValue,i)!=0){
                SuccessNum+=1;
            }
        }
        model.addAttribute("message","修改参数提交数"+len+"成功修改"+SuccessNum);
        return "message/success";
    }
}
