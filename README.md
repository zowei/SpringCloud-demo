# SpringCloud-demo
技术栈

1. 注册中心使用 eureka

2. 网关使用 springcloud-gateway

3. 服务之间的远程调用使用 feign

###项目介绍
1. 有两个微服务，一个是订单服务 order-service，一个是用户服务叫 user-service

2. 网关使用 gateway，所有服务都必须注册到 eureka

3. 当请求到达网关时，会通过路由被代理到不同的服务之间，查询订单的服务会去查询用户，该过程使用feign作为远程调用

###项目启动

1. 两个服务分别连接不同的数据库，各自的sql文件在各自服务的目录下，先生成好数据库及数据表

2. 将注册中心eureka先启动，然后启动其余的微服务，访问 http://localhost:10086/

![image](https://github.com/zowei/SpringCloud-demo/assets/36793718/3ba84379-d393-4c9e-b710-06d033c36b10)

观察所有服务是否都已经注册到 eureka
3. 通过网关访问 user-service：http://localhost:10010/user/3?auth=admin

![image](https://github.com/zowei/SpringCloud-demo/assets/36793718/27f82134-bc94-4668-90bc-dd3448ffe11a)

4. 通过网关访问 order-service，订单服务使用 feign 远程调用user-service 得到该订单关联的用户：http://localhost:10010/order/4?auth=admin

![image](https://github.com/zowei/SpringCloud-demo/assets/36793718/71df2999-db1b-4a6a-8561-f7ac96d145bc)

注意: 在网关中配置了全局路由过滤器，要求在请求头中加上"?auth=admin",才能通过路由
