package com.atbjut.boot.controller;

import com.atbjut.boot.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;


@Controller
public class PersonController {

    //  1.如果一个方法上没有加 @ResponseBody 注解,则Spring会将方法的返回值封装为一个ModelAndView对象返回
    //  2.如果一个方法上加入了 @ResponseBody 注解时,当返回值是字符串时，则返回字符串至客户端
    //    如果返回值是一个对象时,则将对象转换为json串,返回到客户端

    @ResponseBody  // 调用 RequestResponseBodyMethodProcessor -> 调用xxxHttpMessageConverter消息转换器
    @GetMapping("/test/person")
    public Person getPerson(){
        Person person = new Person();
        person.setAge(12);
        person.setBoss(true);
        person.setUserName("张三");
        person.setBirth(new Date());

        return person;
    }

}
