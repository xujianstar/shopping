package com.itheima.controller;


import com.itheima.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("hello", "hello welcome");
        //集合数据
        List<User> users = new ArrayList<User>();
        users.add(new User(1,"张三","深圳"));
        users.add(new User(2,"李四","北京"));
        users.add(new User(3,"王五","武汉"));
        model.addAttribute("users",users);

        Map<String,String> map = new HashMap<String,String>();
        map.put("No","123");
        map.put("address","深圳");
        map.put("No2","123345");
        model.addAttribute("map",map);

        //存储一个数组
        String[] names = {"张三","李四","王五"};
        model.addAttribute("names",names);
        model.addAttribute("now",new Date());
        model.addAttribute("age",20);
        return "demo1";
    }
}
