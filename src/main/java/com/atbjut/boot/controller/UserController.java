package com.atbjut.boot.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {

    //rest 风格请求方式
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String getUser(){
        return "GET-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.POST)
    public String saveUser(){
        return "POST-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.PUT)
    public String putUser(){
        return "PUT-张三";
    }

    @RequestMapping(value = "/user",method = RequestMethod.DELETE)
    public String deleteUser(){
        return "DELETE-张三";
    }

    @RequestMapping(value = "/user/123456",method = RequestMethod.GET)
    public Map testInterceptor(HttpServletRequest request){

        Map<String,Object> map = new HashMap<>();

        map.put("preHandle-msg",request.getAttribute("preHandle-msg"));
        map.put("preHandle-code",request.getAttribute("preHandle-code"));
        map.put("to-user","执行完毕该方法，只有在执行该方法之前塞进request域的信息能拿到，在执行完该方法之后塞进request的信息则无法再获取");

        return map;
    }
}
