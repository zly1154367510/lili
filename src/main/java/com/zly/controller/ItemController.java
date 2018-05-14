package com.zly.controller;

import com.zly.model.*;
import com.zly.service.ItemCatService;
import com.zly.service.ItemParamService;
import com.zly.service.ItemService;
import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.jws.WebParam;
import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zly11 on 2018/4/29.
 */
@Controller
public class ItemController {

    @Autowired
    private ItemService itemService;

    @Autowired
    private ItemCatService itemCatService;

    @Autowired
    private ItemParamService itemParamService;

    @RequestMapping("/item")
    //分页查询商品列表
    public String getItem(@RequestParam(value = "page", required = false, defaultValue = "1") int page, Model model) {
        //System.out.println(page);
        List<Item> i = itemService.getItem(page, 10);
        long pages = itemService.getItemNum() / 10;
        model.addAttribute("list", i);
        model.addAttribute("pages", pages);
        model.addAttribute("page",page);
        model.addAttribute("nextPage", page + 1);
        model.addAttribute("previousPage", page - 1);
        return "mobilePhone/index";

    }

    @RequestMapping("/additem")
    public String addItemView(Model model) {

        model.addAttribute("Item", new Item());
        model.addAttribute("list", itemCatService.getItemCatParen());
        return "mobilePhone/addItem";
    }

    @RequestMapping("/addItemSelect")
    public List<ItemCat> addItemSelect() {
        return itemCatService.getItemCatParen();
    }

    @RequestMapping("/saveItem")
    public String addItemDo(@ModelAttribute("Item") @Valid Item item, Errors errors, Model model, HttpServletRequest request) {
        System.out.println(item.getCid());
        if (errors.hasErrors()) {
            //  model.addAttribute("Item",new Item());

            return "mobilePhone/addItem";
        } else {
            List<MultipartFile> files = item.getImages();
            List<String> fileNames = new ArrayList<String>();
            if (files != null && files.size() > 0) {
                for (MultipartFile multipartFile : files) {
                    String fileName = multipartFile.getOriginalFilename();
                    fileNames.add(fileName);
                    System.out.println(fileName);
                    File imagesFile = new File("images", fileName);
                    item.setImage("images"+fileName);
                    itemService.addItem(item);

                    try {
                        multipartFile.transferTo(imagesFile);
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }

                return "/message/success";
            }
            return "";
        }
    }

    @RequestMapping("/addItemParameter")
    public String addItemParameter(@RequestParam Long itemId, Model model) {
        Item i = itemService.getItemById(itemId);
        List<ItemParamGroup> list = itemParamService.findAllKeyGroup(i.getCid());
        List<ItemParamValue> list1 = itemParamService.findItemParamValueByItemId(itemId);
        model.addAttribute("groupList", list);
        model.addAttribute("paramValueList", list1);
        model.addAttribute("item", i);
        return "mobilePhone/addItemParameter";
    }

    @RequestMapping("/addItemParameterDo")
    public String addItemParameterDo(@RequestParam String[] paramValue, @RequestParam Long[] paranKey, @RequestParam Long itemId,Model model ){
        for (int i = 0;i<paranKey.length;i++){
            if(paramValue[i].equals("")||paramValue[i]==""){
                continue;
            }else {
                itemParamService.updOrInsItemParam(paranKey[i],paramValue[i],itemId);
            }
        }
        model.addAttribute("message","修改商品属性成功");
        return "message/success";
    }


    //批量删除item
    @RequestMapping("/delItemDo")
    public String delItemDo(@RequestParam String[] itemId, Model model){
        int flagNum = itemId.length;
        int delSuccessNum = 0;
        for (String i : itemId){
            int f = itemService.delItemById(i);
            System.out.println("f:"+f);
            if (f !=0 ){

                delSuccessNum += 1;
            }
        }
        model.addAttribute("message","成功删除"+delSuccessNum+"个,失败"+(flagNum-delSuccessNum)+"个");
        return "message/success";
    }

}