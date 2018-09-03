package com.coderV.springBootstudythymeleaf;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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
    public String testEach(Model model){

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
    public String index2(Model model){
        Person person = new Person() ;

        person.setAge(22);
        person.setName("xxx");
        person.setWxCode("coldStone");

        model.addAttribute("person", person);

        return "index";
    }
    public String index3(Model model){
        Person person = new Person() ;

        person.setAge(22);
        person.setName("xxx");
        person.setWxCode("coldStone");

        model.addAttribute("person", person);

        return "index";
    }
    public String index4(Model model){
        Person person = new Person() ;

        person.setAge(22);
        person.setName("xxx");
        person.setWxCode("coldStone");

        model.addAttribute("person", person);

        return "index";
    }

}
