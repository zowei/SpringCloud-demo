package com.atbjut.boot.controller;

import com.atbjut.boot.bean.Product;
import com.atbjut.boot.mapper.ProductMapper;
import com.atbjut.boot.util.JedisUtil;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class ProductController {

    @Resource
    ProductMapper productMapper;

    @GetMapping("/product")
    public List<Product> getProduct(){
        return productMapper.getProduct();
    }

    @GetMapping("/getProductById")
    public Product getProductById(int id){
        Product product = null;
        // 1. 查看 redis 缓存中是否有数据
        product = JedisUtil.getProductByRedis(id);
        if(product == null){  // redis 中没有该商品
            System.out.println("redis中没有该商品");
            // 进 mysql 中查询
            product = productMapper.getProductById(id);
            if(product==null){ // mysql 中没有
                System.out.println("mysql 中未查询到该商品");
                // 缓存穿透---创建一个不存在的key
                Product p = new Product(id," ", 0.0F,0);
                JedisUtil.saveToRedis(p);
            }else { // mysql 中有
                System.out.println("mysql: "+product);
                // 返回给前端的同时也要将数据写入到 redis 中
                long flag = JedisUtil.saveToRedis(product);
                System.out.println("save flag:"+flag);
            }
        }else {  // redis 中有该商品
            System.out.println("redis: " + product);
        }
        return product;
    }
}
