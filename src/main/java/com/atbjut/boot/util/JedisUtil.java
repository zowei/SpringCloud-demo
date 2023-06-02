package com.atbjut.boot.util;

import com.atbjut.boot.bean.Product;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Random;

public class JedisUtil {
    private static JedisPool jedisPool;
    static{
        // 配置连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);  // 设置最大连接数
        config.setMaxIdle(5);  // 设置最大空闲连接数
        config.setBlockWhenExhausted(false);  // 连接耗尽时不阻塞

        // 创建连接池
        jedisPool = new JedisPool(config,"101.42.236.82",6379);
    }

    // 从数据池获取 Jedis 连接
    public static Jedis getJedisPool(){
        return jedisPool.getResource();
    }

    // 存储商品到 redis---key:(product:id)  field:  value
    public static long saveToRedis(Product product){
        Jedis jedis = JedisUtil.getJedisPool();

        HashMap<String,String> hashMap = new HashMap();
        hashMap.put("name",product.getName());
        hashMap.put("price",String.valueOf(product.getPrice()));
        hashMap.put("category",String.valueOf(product.getCategory()));

        String key = "product:" + product.getId();
        long flag = jedis.hset(key, hashMap);
        // 生成一个 [0,100) 左闭右开的随机数
        int random = new Random().nextInt(100);
        jedis.expire(key,3600L+random);

        jedis.close();
        return flag;
    }
    // 从 redis 读取数据
    public static Product getProductByRedis(int id){
        Jedis jedis = JedisUtil.getJedisPool();
        Product product = null;
        String key = "product:" + id;
        if(jedis.exists(key)){
            String name = jedis.hget(key,"name");
            String price = jedis.hget(key,"price");
            String category = jedis.hget(key,"category");
            product = new Product(id,name,Float.parseFloat(price),Integer.parseInt(category));
        }
        jedis.close();
        return product;
    }
}
