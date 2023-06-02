package cn.itcast.order.controller;

import cn.itcast.order.bean.Order;
import cn.itcast.order.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/order")
public class OrderController {

   @Resource
   private OrderService orderService;

    @GetMapping("{orderId}")
    public Order queryOrderByUserId(@PathVariable("orderId") Long orderId) {
        // 根据id查询订单并返回

        // 1.使用 feign 实现远程调用
        return orderService.queryOrderById(orderId);

        // 2.使用 RestTemplate 实现远程调用
        // return orderService.queryOrderByIdViaRestTemplate(orderId);
    }
}
