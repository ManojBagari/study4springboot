package com.coderV.springBootstudythymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HelloController {
    @GetMapping("/hello")
    /* @RequestMapping(value = "/",method = RequestMethod.GET)*/
    public String index(){
        return "hello";
    }
}
