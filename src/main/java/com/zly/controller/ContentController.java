package com.zly.controller;

import com.zly.Utils.FileUpload;
import com.zly.model.Content;
import com.zly.service.ContentCategoryService;
import com.zly.service.ContentService;
import org.apache.ibatis.annotations.Select;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;

/**
 * Created by zly11 on 2018/5/12.
 */
@Controller
public class ContentController {

    @Autowired
    private ContentCategoryService contentCategoryService;

    @Autowired
    private ContentService contentService;

    //添加广告视图跳转
    @RequestMapping("/addAdv")
    private String addAdvView(Model model){
        model.addAttribute("content",new Content());
        model.addAttribute("list",contentCategoryService.findAllContentCategory());
        return "adv/addAdv";
    }

    //处理添加广告表单
    @RequestMapping("/addAdvDo")
    private String addAdvDo(HttpServletRequest request, Model model, @ModelAttribute("content") @Valid Content content,Errors errors){
        if (errors.hasErrors()) {
            //  model.addAttribute("Item",new Item());
            model.addAttribute("list",contentCategoryService.findAllContentCategory());
            return "adv/addAdv";
        }else{
            MultipartFile file = content.getImages();
            if (file.getSize() > 0 && file != null){
                String fileName = file.getOriginalFilename();
                File imagesFile = new File("D:\\wamp\\www\\taotaoResource\\contentImages", fileName);
                content.setPic("http://localhost/taotaoResource/contentImages/"+fileName);
                int i = contentService.addAdv(content);

                if (i == 1){
                    try {
                        file.transferTo(imagesFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    };
                    model.addAttribute("message","添加广告成功");
                    return "/message/success";
                }


            }
            return "/message/error";
        }

    }

    @RequestMapping("/adv")
    public String adv(@RequestParam(value = "page", required = false, defaultValue = "1") int page,Model model){
        model.addAttribute("list",contentService.findAllContent(page));
        long pages = contentService.findContentNum() / 5;
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        return "adv/adv";
    }

    //批量删除Contet
    @RequestMapping("/delContentDo")
    public String delItemDo(@RequestParam String[] itemId, Model model){
        int flagNum = itemId.length;
        int delSuccessNum = 0;
        for (String i : itemId){
            ;
            int f = contentService.delItemById(i);
            System.out.println("f:"+f);
            if (f !=0 ){

                delSuccessNum += 1;
            }
        }
        model.addAttribute("message","成功删除"+delSuccessNum+"个,失败"+(flagNum-delSuccessNum)+"个");
        return "message/success";
    }

}
