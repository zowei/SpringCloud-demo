package com.atbjut.boot.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolDemo {

    public static void main(String[] args) {
        // 配置连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(10);  // 设置最大连接数
        config.setMaxIdle(5);  // 设置最大空闲连接数
        config.setBlockWhenExhausted(false);  // 连接耗尽时不阻塞
        
        // 创建连接池
        JedisPool jedisPool = new JedisPool(config,"101.42.236.82",6379);
        Jedis jedis = jedisPool.getResource();
        jedis.set("name","王五");
        System.out.println(jedis.get("name"));

        // 释放连接池
        jedisPool.close();
    }
}
