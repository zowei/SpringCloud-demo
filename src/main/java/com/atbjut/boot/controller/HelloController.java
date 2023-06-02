package com.atbjut.boot.controller;

import com.atbjut.boot.bean.Person;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
@Slf4j
public class HelloController {

    @Autowired
    Person person;

    //非 rest 风格请求
    @RequestMapping("/getHello")
    public Person hello01(){
        log.info("收到前端请求getHello请求.");
        person.toString();
        return person;

    }

    @RequestMapping("/putHello")
    public Person hello02(){

        //log.info("收到前端请求/////");
        //System.out.println(person.getAge());
        log.info("收到前端请求putHello请求.");
        person.toString();
        return person;

    }

    @RequestMapping("/deleteHello")
    public Person hello03(){

        //log.info("收到前端请求/////");
        //System.out.println(person.getAge());
        log.info("收到前端请求deleteHello请求.");
        person.toString();
        return person;

    }
}
