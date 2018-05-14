package com.zly.Utils;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.lang.reflect.Field;

/**
 * Created by zly11 on 2018/5/12.
 */
public class FileUpload {


    //一张图片的上传
    public  static <T>T ImageUpDaload(HttpServletRequest request,T t){
       try{
           Field field = t.getClass().getField("images");
           field.setAccessible(true);
           System.out.println(field.get("images"));
           MultipartFile file = (MultipartFile) field.get("images");
           return t;
       }catch (Exception e){
           e.printStackTrace();
       }
        return null;
    }
}
