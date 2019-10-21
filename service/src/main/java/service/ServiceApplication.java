package service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lzr on 2017/4/15.
 * 通过注解@EnableEurekaClient 表明自己是一个eurekaclient（服务提供者）.
 * 仅仅@EnableEurekaClient是不够的，还需要在配置文件中注明自己的服务注册中心的地址，
 */

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class ServiceApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceApplication.class, args);
    }

    @RequestMapping("/service2")
    public String service(){
        return "service";
    }

    @Value("${server.port}")
    String port;

    @RequestMapping("/hi")
    public String home(@RequestParam(value = "name", defaultValue = "forezp") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    @GetMapping("/service")
    public String service2(){
        System.out.println("白页");
        return "service";
    }

    @GetMapping("404")
    public String e404() {
        System.out.println("404............");
        return "这真的是一个404页面，你看看";
    }
}
