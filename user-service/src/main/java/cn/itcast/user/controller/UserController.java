package cn.itcast.user.controller;

import cn.itcast.user.config.PatternProperties;
import cn.itcast.user.bean.User;
import cn.itcast.user.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Slf4j
@RestController
@RequestMapping("/user")
// @RefreshScope
public class UserController {

    @Resource
    private UserService userService;
    @Resource
    private PatternProperties properties;

    @GetMapping("/prop")
    public PatternProperties properties(){
        return properties;
    }

    @GetMapping("/now")
    public String now(){
        return LocalDateTime.now().format(DateTimeFormatter.ofPattern(properties.getDateformat()));
    }

    @GetMapping("/{id}")
    public User queryById(@PathVariable("id") Long id,
                          @RequestHeader(value = "truth", required = false) String truth) {
        System.out.println("请求头添加的参数 - truth: " + truth);
        return userService.queryById(id);
    }
}
