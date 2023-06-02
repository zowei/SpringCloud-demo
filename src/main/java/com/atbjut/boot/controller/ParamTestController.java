package com.atbjut.boot.controller;

import com.atbjut.boot.bean.Pet;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ParamTestController {

    //@PathVariable获取: /car/{id}/owner/{username}
    @GetMapping("/car/{id}/owner/{username}")
    public Map<String, Object> getCar(@PathVariable("id") Integer id,
                                      @PathVariable("username") String username,
                                      @PathVariable Map<String,Object> pv){

        //使用@PathVariable() 接受单个参数值
        Map<String, Object> map1 = new HashMap<>();
        map1.put("id",id);
        map1.put("username", username);

        //使用@PathVariable() Map<String,Object> 接受所有参数值
        Map<String, Object> map2 = new HashMap<>();
        map2 = pv;
        map2.put("comment","这是使用map接受的所有参数值！！！！！！");


        return map2;
    }

    @GetMapping("/car/RequestHeader/{id}/{username}")
    public Map<String, Object> getRequestHeader(@PathVariable("id") Integer id,
                                                @PathVariable("username") String username,
                                                @RequestHeader("user-agent") String userAgent,
                                                @RequestHeader("Host") String host){

        //使用@PathVariable() 接受单个参数值
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username", username);
        map.put("user-agent", userAgent);
        map.put("host", host);

        return map;
    }

    //@RequestParam获取: car/RequestParam/?id=3&age=18&inters=basketball&inters=game"
    @GetMapping("/car/RequestParam/")
    public Map<String, Object> getRequestParam( @RequestParam("id") String id,
                                                @RequestParam("age") Integer age,
                                                @RequestParam("inters") List<String> inters){
//        @RequestParam("inters") String inters
        Map<String, Object> map = new HashMap<>();

        map.put("id",id);
        map.put("age", age);
        map.put("inters", inters);

        return map;
    }

    @GetMapping("/car/CookieValue/{id}/{username}")
    public Map<String, Object> getCookieValue(@PathVariable("id") Integer id,
                                                @PathVariable("username") String username,
                                                @CookieValue("_ga") String _ga){

        //使用@PathVariable() 接受单个参数值
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username", username);
        map.put("_ga", _ga);

        return map;
    }


    @PostMapping ("/car/RequestBody/save")
    public Map<String, Object> getRequestBody(@RequestBody() String content){

        //使用@RequestBody() 接受请求体
        Map<String, Object> map = new HashMap<>();
        map.put("pet", content);

        return map;
    }

    @GetMapping("/car/MatrixVariable/{id}/{username}")
    public Map<String, Object> getMatrixVariable(@PathVariable("id") Integer id,
                                                 @PathVariable("username") String username,
                                                 @MatrixVariable("user-agent") String userAgent){

        //使用@PathVariable() 接受单个参数值
        Map<String, Object> map = new HashMap<>();
        map.put("id",id);
        map.put("username", username);
        map.put("user-agent", userAgent);

        return map;
    }
}
