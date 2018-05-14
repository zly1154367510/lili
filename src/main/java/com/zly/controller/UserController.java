package com.zly.controller;

import com.zly.model.User;
import com.zly.service.UserSercice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by zly11 on 2018/4/28.
 */

@Controller
public class UserController {

    @Autowired
    private UserSercice userSercice;

    @RequestMapping("/login")
    public String login(@RequestParam String username){
        System.out.println("用户来登陆"+username);
        User user = userSercice.login(username);
        System.out.println(user.getPassword());
        return "item/index";
    }
}
