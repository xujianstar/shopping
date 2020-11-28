package com.example.elasticsearch;

import com.example.repository.UserReposiory;
import com.example.repository.XujianEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

public class EsController {
    @Autowired
    UserReposiory userReposiory;
    @RequestMapping("/findUser")
    public Optional<XujianEntity> findUser(String id) {
        return userReposiory.findById(id);
    }
}
