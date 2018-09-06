package com.coderv.springbootmybatis.controller;

import com.coderv.springbootmybatis.entity.User;
import com.coderv.springbootmybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class MybatisController {

    @Autowired
    private UserService userService;

    @GetMapping("/user/get/{id}")
    public User user(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping("/user/add")
    public int addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @PostMapping("/user/update")
    public int updateUser(@RequestBody User user){
        return userService.updateUser(user);
    }

    @GetMapping("/user/delete/{id}")
    public int deleteUser(@PathVariable int id){
        return userService.deleteById(id);
    }
}
