package com.coderv.springbootmybatis.service.impl;

import com.coderv.springbootmybatis.entity.User;
import com.coderv.springbootmybatis.mapper.UserMapper;
import com.coderv.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private  UserMapper userMapper;
    @Override
    public User findUserById(int id) {
        return userMapper.findUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return  userMapper.updateUser(user);
    }

    @Override
    public int deleteById(int id) {
        return userMapper.deleteById(id);
    }
}
