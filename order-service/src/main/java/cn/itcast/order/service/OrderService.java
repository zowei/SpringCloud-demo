package cn.itcast.order.service;

import cn.itcast.feign.clients.UserClient;
import cn.itcast.feign.pojo.User;
import cn.itcast.order.mapper.OrderMapper;
import cn.itcast.order.bean.Order;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import javax.annotation.Resource;

@Service
public class OrderService {

    @Resource
    private OrderMapper orderMapper;
    @Resource
    private UserClient userClient;

    public Order queryOrderById(Long orderId) {
        // 1.查询订单
        Order order = orderMapper.findById(orderId);
        // 2.用 Feign远程调用查询 user
        User user = userClient.findById(order.getUserId());
        // 3.封装 user到 Order
        order.setUser(user);
        // 4.返回
        return order;
    }

//    @Resource
//    private RestTemplate restTemplate;
//    public Order queryOrderByIdViaRestTemplate(Long orderId) {
//        // 1.查询订单
//        Order order = orderMapper.findById(orderId);
//        // 2.利用RestTemplate发起 http请求，查询用户
//
//        // 2.1.url路径---硬编码
//        String url = "http://localhost:8081/user/" + order.getUserId();
//
//        // 使用 eureka 注册中心的方式
//        // 注册中心中注册的名称 = 该服务的 ip + 端口
//        String url_eureka = "http://user-service/user/" + order.getUserId();
//
//        // 2.2.发送 http请求，实现远程调用 RPC
//        User user = restTemplate.getForObject(url, User.class);
//
//        // 3.封装 user到 Order
//        order.setUser(user);
//
//        // 4.返回
//        return order;
//    }
}
