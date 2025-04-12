package com.wuzengrui.controller;


import com.aliyun.oss.AliOSSUtils;
import com.aliyuncs.exceptions.ClientException;
import jakarta.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
public class UploadController {

    @Resource(name = "aliOSSUtils")
    private AliOSSUtils aliOSSUtils;

    @PostMapping("/upload")
    public String upload(MultipartFile image) throws IOException, ClientException {
        return aliOSSUtils.upload(image);
    }
}
