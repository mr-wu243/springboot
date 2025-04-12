package com.wuzengrui.controller;

import com.aliyuncs.exceptions.ClientException;
import com.wuzengrui.pojo.Result;
import com.wuzengrui.utils.AliOSSUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@Slf4j
public class UploadController {

    @Resource(name = "aliOSSUtils")
    private AliOSSUtils ossUtils;
//    @PostMapping("/upload")
    /*public Result upload(String username, Integer age, MultipartFile[] image) throws IOException {
        log.info("上传图片");
//        System.out.println(username);
//        System.out.println(age);
//        System.out.println(image);
//        将文件存储在磁盘目录当中

//        获取后缀名：
//        方法一
//        String extname=new String("");
//        for(int i=image.getOriginalFilename().length()-1;i>=0;i--){
//            extname=image.getOriginalFilename().charAt(i)+houzhui;
//            if(image.getOriginalFilename().charAt(i) == '.'){
//                break;
//            }
//        }
//        方法二
        for (MultipartFile file : image) {
            String fileName = UUID.randomUUID().toString();
            int index = file.getOriginalFilename().lastIndexOf(".");
            String extname = file.getOriginalFilename().substring(index);
            fileName += extname;
            file.transferTo(new File("C:\\Users\\wuzen\\Desktop\\" + fileName));
        }
//        int index=image.getOriginalFilename().lastIndexOf(".");
//        String extname=image.getOriginalFilename().substring(index);
//        fileName+=extname;
//        log.info("新文件名为："+fileName);
//        image.transferTo(new File("C:\\Users\\wuzen\\Desktop\\"+fileName));
        return Result.success();
    }*/

    @PostMapping("/upload")
    public Result upload(@RequestParam("image") MultipartFile file) throws IOException, ClientException {
        return Result.success(ossUtils.upload(file));
    }
}
