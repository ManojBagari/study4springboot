package com.coderv.springbootmybatis.service;

import com.coderv.springbootmybatis.entity.User;

public interface UserService {

    User findUserById(int id);

    int  addUser(User user);

    int  updateUser(User user);

    int  deleteById(int id);
}
