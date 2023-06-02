package com.atbjut.boot.controller;

import com.atbjut.boot.bean.Boss;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class CustomObjectParamController {


    @PostMapping("/custom/param/noRequestBody")
    public Map saveUser(Boss boss){
        Map<String,String> map = new HashMap<>();

        map.put("userName",boss.getUserName());
        map.put("age"," "+boss.getAge());
        map.put("birth",""+boss.getBirth());
        map.put("car.name",""+boss.getCar().getName());
        map.put("car.age",""+boss.getCar().getAge());

        return map;
    }


    // @RequestBody: @RequestBody注解必须接收 json 格式请求数据，不能接收get请求和post表单数据(表单数据必须转化为json格式)
    @PostMapping("/custom/param/RequestBody")
    public Map saveUser1(@RequestBody Boss boss){

        Map<String,String> map = new HashMap<>();

        map.put("userName",boss.getUserName());
        map.put("age"," "+boss.getAge());
        map.put("birth",""+boss.getBirth());
        map.put("car.name",""+boss.getCar().getName());
        map.put("car.age",""+boss.getCar().getAge());

        return map;
    }
}
