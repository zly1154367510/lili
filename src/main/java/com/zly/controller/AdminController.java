package com.zly.controller;

import com.zly.model.Admin;
import com.zly.service.AdminService;
import com.zly.service.UserSercice;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by zly11 on 2018/5/15.
 */
@Controller
public class AdminController {

    @Autowired
    private AdminService adminService;

    @Autowired
    private UserSercice userSercice;

    @RequestMapping("admin/login")
    public String login(){
        return "admin/login";
    }

    @RequestMapping("admin/loginDo")
    public ModelAndView loginDo(Model model, @RequestParam("username")String username, @RequestParam("password")String password, HttpServletRequest request){

        Admin admin = adminService.login(username,password);
        if (admin != null){
           // System.out.println("我是登录session"+request.getSession().getId());
            request.getSession().setAttribute("username",username);
            return new ModelAndView("redirect:/item");
        }
        model.addAttribute("message","账号或密码错误,请重试");
        return new ModelAndView("message/success");
    }

    @RequestMapping("admin/logOut")
    public String logout(HttpServletRequest request){
      //  System.out.println("我是退登Session"+request.getSession().getId());
        request.getSession().setAttribute("username","");
        return "admin/login";
    }

    @RequestMapping("/userList")
    public String userList(Model model,@RequestParam(value = "page", required = false, defaultValue = "1") int page){
        model.addAttribute("list",userSercice.findAll(page,10));
        long pages = userSercice.getItemNum() / 10;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        return "user/user";
    }

    @RequestMapping("/banUser")
    public String banUserDo(HttpServletRequest request,Model model){
        //System.out.println(request.getParameter("userId"));
        Long id = new Long(request.getParameter("userId"));
        String reason = request.getParameter("reason");
        if (userSercice.banUser(id,reason)!=0){
            model.addAttribute("message","成功封禁id为"+id+"的用户");
            return "message/success";
        }
        return null;

    }

}
