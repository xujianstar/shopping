package com.alibaba.web.controller.consumer;

import com.alibaba.provider.HelloService;
import com.alibaba.provider.User;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;
import java.util.List;

public class HelloController {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-consumer.xml");

        HelloService helloService = (HelloService)context.getBean("helloService");
        String result = helloService.sayHello("尼玛");
        System.out.println(result);
        User user = new User();
        user.setName("神蛊咒");
        user.setAge(1000);
        List<User> list = helloService.getUsers(user);
        for(User user1 : list){
            System.out.println(user1.getName()+":"+user1.getAge());
        }



    }
}
