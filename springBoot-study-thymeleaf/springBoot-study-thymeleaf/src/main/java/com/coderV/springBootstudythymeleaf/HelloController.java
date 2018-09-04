package com.coderV.springBootstudythymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Controller
public class HelloController {
    @RequestMapping(value = "/index",method = RequestMethod.GET)
    public String index(Model model){
        Person person = new Person() ;
        person.setAge(22);
        person.setName("xxx");
        person.setWxCode("coldStone");
        model.addAttribute("person", person);
        return "index";
    }

    @RequestMapping(value = "/personList")
    public String testList(Model model){

        List<Person> personList = new ArrayList<>();
        for (int i = 0; i < 5 ; i++) {
            Person person = new Person() ;
            person.setAge(i);
            person.setName(i+"xxx");
            person.setWxCode("coldStone");
            personList.add(person);
        }
        model.addAttribute("personList", personList);
        return "index";
    }
    @RequestMapping(value = "/personMap")
    public String testMap(Model model){
        Map<String,Object >  personMap = new HashMap<>();
        for (int i = 0; i < 5 ; i++) {
            Person person = new Person() ;
            person.setAge(i);
            person.setName(i+"xxx");
            person.setWxCode("coldStone");
            personMap.put(String.valueOf(i),person);
        }
        model.addAttribute("personMap",personMap);
        model.addAttribute("wxCode","coldStone");

        return "index";
    }


    @RequestMapping(value = "/testIf")
    public String testIf(Model model){
        Person person = new Person() ;
        person.setSex(1);
        model.addAttribute("person", person);
        return "index";
    }



    @RequestMapping(value = "/request")
    public String request(Model model,  HttpServletRequest request){
        request.setAttribute("wxCode","codeStone");
        request.getSession().setAttribute("name","Tom");
        model.addAttribute("date",new Date());
        return "index";
    }

}
