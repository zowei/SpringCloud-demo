package com.atbjut.boot.jedis;

import redis.clients.jedis.Jedis;

public class JedisDemo {
    public static void main(String[] args) {
        // 通过 ip 和端口连接 redis
        Jedis jedis = new Jedis("101.42.236.82",6379);
        System.out.println(jedis.ping());

        Jedis jedis1 = new Jedis("101.43.154.108",6380);
        Jedis jedis5 = new Jedis("101.43.154.108",6381);
        System.out.println(jedis1.ping());
        System.out.println(jedis5.ping());

        Jedis jedis2 = new Jedis("101.43.154.108",26379);
        Jedis jedis3 = new Jedis("101.43.154.108",26380);
        Jedis jedis4 = new Jedis("101.43.154.108",26381);
        System.out.println(jedis2.ping());
        System.out.println(jedis3.ping());
        System.out.println(jedis4.ping());


        // 设置数据
        System.out.println(jedis.set("u0","zhangsan"));
        // 获取数据
        System.out.println(jedis.get("u0"));
        // 判断是否存在某个 key
        System.out.println(jedis.exists("name"));
        // 删除 key
        System.out.println(jedis.del("name"));

        jedis.close();
        jedis1.close();
        jedis2.close();
    }
}
