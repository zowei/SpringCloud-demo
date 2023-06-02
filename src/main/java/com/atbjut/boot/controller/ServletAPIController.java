package com.atbjut.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

@Controller
public class ServletAPIController {

    @GetMapping("/servlet/param")
    // Map<String,Object> map,Model model,HttpServletRequest request: 都可以给request域里面放数据
    public String testServletAPI(Map<String,Object> map,
                                 Model model,
                                 HttpServletRequest request,
                                 HttpServletResponse response){

        // 1.map 添加的属性值也会放到 request 请求域当中
        map.put("hello", "world123456");

        // 2.model 添加的属性值也会放到 request 请求域当中
        model.addAttribute("world","hello654321");
        // 3.request 添加的属性值也会放到 request 请求域当中
        request.setAttribute("message","hello World!");

        Cookie cookie = new Cookie("c1","v1");
        cookie.setDomain("localhost");
        response.addCookie(cookie);

        return "forward:/servlet/success";
    }

    @ResponseBody
    @GetMapping("/servlet/success")
    public Map<String, Object> success(@RequestAttribute(value = "msg",required = false) String msg,
                                       @RequestAttribute(value = "code", required = false) Integer code,
                                       HttpServletRequest request,
                                       HttpServletResponse response){

        Map<String, Object> map = new HashMap<>();

        map.put("mapPutMessage",request.getAttribute("hello"));
        map.put("modelAddAttribute",request.getAttribute("world"));
        map.put("requestSetAttributeMessage",request.getAttribute("message"));

        map.put("response.getStatus",response.getStatus());

        return map;
    }
}
