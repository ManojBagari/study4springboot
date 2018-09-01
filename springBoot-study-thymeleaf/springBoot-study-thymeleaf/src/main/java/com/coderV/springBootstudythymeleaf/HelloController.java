package com.coderV.springBootstudythymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HelloController {
    @GetMapping("/hello")
    /* @RequestMapping(value = "/",method = RequestMethod.GET)*/
    public ModelAndView index(){
        //创建2个person
        Person p1 = new Person();
        p1.setAge(1);
        p1.setName("peter");

        Person p2 = new Person();
        p1.setAge(1);
        p1.setName("tom");

        //创建集合存储
        List<Person> list = new ArrayList<>(2);
        list.add(p1);
        list.add(p2);

        ModelAndView mv = new ModelAndView("hello");

        //添加一个person
        mv.addObject("p1",p1);
        //添加集合
        mv.addObject("list",list);
        return  mv;
    }
}
