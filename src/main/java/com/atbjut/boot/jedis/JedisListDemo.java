package com.atbjut.boot.jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;

public class JedisListDemo {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("101.42.236.82",6379);
        // 操作 List 类型
        jedis.lpush("age","1","2","3","4","5","6","7","8","9");
        jedis.rpush("user","张三","李四","王五");
        System.out.println(jedis.lindex("age",2));

        // 操作 Hash 类型
        jedis.hset("person","person1","胡桃");
        // 通过map方式传入value
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("name","甘雨");
        hashMap.put("age","23");
        jedis.hset("genshin",hashMap);
        System.out.println(jedis.hget("genshin","name"));

        // 操作 Set 类型
        jedis.sadd("names","a","b","c","a");
        System.out.println(jedis.smembers("names"));

        // 操作有序集合 Zset 类型
        jedis.zadd("score",88,"张三");
        jedis.zadd("score",90,"李四");
        jedis.zadd("score",87,"王五");
        System.out.println(jedis.zrange("score",0,1));
    }
}
