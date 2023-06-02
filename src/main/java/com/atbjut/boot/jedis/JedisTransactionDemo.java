package com.atbjut.boot.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

public class JedisTransactionDemo {

    public static void main(String[] args) {
        /**
         * 通过 ip 和端口连接 redis
         */
        Jedis jedis = new Jedis("101.42.236.82",6379);
        System.out.println(jedis.ping());
        // watch 命令
        jedis.watch("name");
        // 开启事务
        Transaction multi = jedis.multi();
        multi.set("name","lisi");
        multi.set("age","23");
        // 撤销事务
//      multi.discard();
        // 提交事务
        multi.exec();
    }
}
