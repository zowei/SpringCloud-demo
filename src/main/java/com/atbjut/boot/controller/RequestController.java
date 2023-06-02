package com.atbjut.boot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class RequestController {

    @GetMapping("/goto")
    public String goToPage(HttpServletRequest request, HttpServletResponse response){
        System.out.println(request.toString());
        request.setAttribute("msg","请求成功了ok");
        request.setAttribute("code",200);

        return "forward:/success";  //转发到 /success请求
    }

    @ResponseBody
    @GetMapping("/success")
    public Map<String, Object> success(@RequestAttribute("msg") String msg,
                          @RequestAttribute("code") Integer code,
                          HttpServletRequest request){

        System.out.println("msg="+msg+"\tcode="+code);
        Object reMsg = request.getAttribute("msg");
        Object reCode = request.getAttribute("code");

        System.out.println("msg="+msg+"\tcode="+code);
        System.out.println("==================================");
        System.out.println("msg="+reMsg+"\tcode="+reCode);

        Map<String, Object> map = new HashMap<>();
        map.put("msg",msg);
        map.put("code", code);

        return map;
    }


    //每一个客户端请求都被封装成一个request对象
    //request 被所有处理该请求的 controller 所共享
    //可以将 request 当作一个 map，往里边添加属性值
    @GetMapping("/car/RequestAttribute/{id}/{username}")
    public Map<String, Object> getRequestAttribute(@PathVariable("id") Integer id,
                                                   @PathVariable("username") String username,
                                                   @RequestAttribute String userAgent){

        //使用@PathVariable() 接受单个参数值
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username", username);
        map.put("user-agent", userAgent);

        return map;
    }

    @ResponseBody
    @GetMapping("/cars/MatrixVariable/{path}")
    // href="cars/MatrixVariable/sell;age=32;brand=byd,yd,audi"
    public Map<String, Object> getMatrixVariable(@MatrixVariable("age") Integer age,
                                                 @MatrixVariable("brand") List<String> brand,
                                                 @PathVariable("path") String path){
        Map<String, Object> map = new HashMap<>();
        map.put("age",age);
        map.put("brand", brand);
        map.put("path", path);

        return map;
    }

    @ResponseBody
    @GetMapping("/boss/{bossId}/{empId}")
    // href="boss/1;age=29/2;age=59"
    public Map<String, Object> getBossMatrixVariable(@MatrixVariable(value = "age",pathVar = "bossId") Integer bossAge,
                                                 @MatrixVariable(value = "age",pathVar = "empId") Integer empAge){
        Map<String, Object> map = new HashMap<>();
        map.put("bossAge",bossAge);
        map.put("empAge", empAge);

        return map;
    }

}
