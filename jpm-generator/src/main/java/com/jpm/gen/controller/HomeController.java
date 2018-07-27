package com.jpm.gen.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: HomeController
 * @author: 李杰
 * @create: 2018-07-12 16:19
 **/
@Controller
public class HomeController {

    @RequestMapping(value = "home")
    public String home(){
        return "home";
    }

}

