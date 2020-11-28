package com.alibaba.provider;

import java.util.ArrayList;
import java.util.List;

public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello(String name) {
        System.out.println("服务端--"+name);
        return "一群傻逼";
    }

    @Override
    public List<User> getUsers(User user) {
        List<User> users = new ArrayList<User>();
        user.setAge(13);
        user.setName("龍門");
        users.add(user);
        return users;
    }


}
