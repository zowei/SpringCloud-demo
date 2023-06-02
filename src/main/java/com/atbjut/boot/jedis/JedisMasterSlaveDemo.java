package com.atbjut.boot.jedis;

import redis.clients.jedis.Jedis;
public class JedisMasterSlaveDemo {

    public static void main(String[] args) throws InterruptedException {
        Jedis jedis_master = new Jedis("localhost",6379);
        Jedis jedis_slave = new Jedis("localhost",26379);

        // 配从不配主
        jedis_slave.slaveof("localhost",6379);
        // 主从复制模式: 默认主节点写，从节点读
        jedis_master.set("dog", "hhh");
        // 从节点更新需要时间
        Thread.sleep(3000);

        System.out.println(jedis_slave.get("dog"));
    }
}
