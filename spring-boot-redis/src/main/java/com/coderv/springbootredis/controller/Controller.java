package com.coderv.springbootredis.controller;

import com.coderv.springbootredis.entity.User;
import com.coderv.springbootredis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/redis")
public class Controller {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserService userService;

    @RequestMapping("/setUserIntoRedis")
    public void setValueIntoRedis(){
        List<User> userList = userService.getUserList();
        redisTemplate.opsForValue().set("userList",userList);
    }

    //普通从redis中查询
    @GetMapping("/getUserFromRedis")
    public List<User> getValueFromRedis(){
        List<User> userList = (List<User>)redisTemplate.opsForValue().get("userList");
        //假如查不到会去数据库中查
        userList = userService.getUserList();
        return userList;
    }

    /*上面的查询会有一个问题，假如一下子出现了100000个人同时查redis,但是redis没有，
    所以下一步就会去数据库中查询，那么这就是常见的缓存穿透问题，
    会造成数据库的雪崩，解决方法如下
    * */
    @GetMapping("/getUserFromRedisOrDb")
    public List<User> getValueFromRedisOrDb(){
        List<User> userList = (List<User>)redisTemplate.opsForValue().get("userList");

        //双重检测锁
        if(null == userList){
            synchronized (this){
                //从redis中获取一下
                userList = (List<User>)redisTemplate.opsForValue().get("userList");
                if(null == userList){
                    //缓存为空，查询一遍数据库
                    userList = userService.getUserList();
                    //再将数据库中的数据放入到redis中
                    redisTemplate.opsForValue().set("userList",userList);
                }
            }
        }
        return userList;
    }

}
