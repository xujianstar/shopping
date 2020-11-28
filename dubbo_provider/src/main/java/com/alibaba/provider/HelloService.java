package com.alibaba.provider;

import java.util.List;

public interface HelloService {
    public String sayHello(String name);
    public List<User> getUsers(User user);
}
