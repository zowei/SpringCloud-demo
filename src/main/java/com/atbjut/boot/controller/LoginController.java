package com.atbjut.boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {

    @GetMapping("/user-login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password
                        ){


        System.out.println(username+"-------------"+password);

        if(username.equals("zouwei")&&password.equals("123456")){
            return "forward:/test.html";
        }else{
            return "forward:/404.html";
        }

    }
}
