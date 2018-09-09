package com.coderv.springbootredis.mapper;

import com.coderv.springbootredis.entity.User;

import java.util.List;

public interface UserMapper {
    User findUserById(int id);

    int  addUser(User user);

    int  updateUser(User user);

    int  deleteById(int id);

    List<User> getUserList();

}