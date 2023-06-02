package com.atbjut.boot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;


// 文件上传 Controller
@RestController
public class FileUploadController {

    @PostMapping("/upload")
    public String uploadFile(@RequestParam("name") String name,
                             @RequestParam("file") MultipartFile file,
                             HttpServletRequest request) throws IOException {

        System.out.println(name);
        //获取图片原始名称
        System.out.println("图片原始名称: "+file.getOriginalFilename());
        //获取文件类型
        System.out.println("文件类型: "+file.getContentType());
        System.out.println("系统根目录: "+System.getProperty("user.dir"));

        String path = System.getProperty("user.dir")+"/src/main/resources/upload/";
        System.out.println("path="+path);
        saveFile(file,path);

        return "上传成功"+file.getOriginalFilename();
    }

    public static void saveFile(MultipartFile file,String path) throws IOException {
        File file1=new File(path);
        if(!file1.exists()){
            //如果不存在该目录，则创建出该目录
            file1.mkdir();
        }
        File dir = new File(path+file.getOriginalFilename());
        file.transferTo(dir);
    }


}
