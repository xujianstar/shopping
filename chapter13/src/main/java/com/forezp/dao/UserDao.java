package com.forezp.dao;


import com.forezp.entity.User;


public interface UserDao {

	User findByUsername(String username);
}
