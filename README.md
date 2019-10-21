# SpringCloud
基于springcloud搭建的微服务程序

## 使用技术
- 版本：springcloud Camden.SR6
- 注册中心：eureka


## 项目结构
- 注册中心 discovery
- 服务1 service（服务提供者）
- 网关 gateway

## 启动项目

1. 启动discovery main方法，访问端口网址类似：http://localhost:8081，可以看见有spring eureka
的界面
当服务提供者向注册中心注册时，它会提供一些元数据，例如主机和端口，URL，主页等。Eureka server 从
每个client实例接收心跳消息。 如果心跳超时，则通常将该实例从注册server中删除。
2. 启动service main 8082
这时候可以看见在注册中心的界面上已经注册了相对应的服务提供者的名字，表明该服务已经上线了
你会发现一个服务已经注册在服务中了，服务名为SERVICE ,端口为8082
但是在接下来访问网址：http://localhost:(服务提供者的端口，**千万别搞错了)8082/service
3. 启动gateway main 8084

## 实现功能
通过注册中心discovery的配置，可以在网关gateway模块，访问service模块上的接口。
