package com.atbjut.boot.jedis;

import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashSet;

public class JedisClusterDemo {

    public static void main(String[] args) {
        // 配置连接池
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxTotal(20);  // 设置最大连接数
        config.setMaxIdle(20);  // 设置最大空闲连接数
        config.setBlockWhenExhausted(false);  // 连接耗尽时不阻塞

        // 构建集群节点
        HashSet<HostAndPort> clusterNode = new HashSet<>();
        // 三个主节点
        clusterNode.add(new HostAndPort("101.43.154.108",6379));
        clusterNode.add(new HostAndPort("101.43.154.108",6380));
        clusterNode.add(new HostAndPort("101.43.154.108",6381));
        // 三个从节点
        clusterNode.add(new HostAndPort("101.43.154.108",26379));
        clusterNode.add(new HostAndPort("101.43.154.108",26380));
        clusterNode.add(new HostAndPort("101.43.154.108",26381));

        JedisCluster jedisCluster = new JedisCluster(clusterNode,config);

        jedisCluster.set("name","雷电将军");
        jedisCluster.hset("person","name","王五");
        jedisCluster.sadd("age","17","23","56");

        System.out.println(jedisCluster.hget("person","name"));

        // 关闭连接
        jedisCluster.close();
    }
}
