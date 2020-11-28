package com.alibaba.provider;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class TestDubbo {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext-dubboprovider.xml");
        context.start();
        System.out.println("服务端开始启动...20881TestDubbo");
        System.in.read(); // 让线程阻塞
    }
}
