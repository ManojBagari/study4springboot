package com.coderv.springbootmybatis.mapper;

import com.coderv.springbootmybatis.entity.User;

public interface UserMapper {
    User findUserById(int id);

    int  addUser(User user);

    int  updateUser(User user);

    int  deleteById(int id);

}