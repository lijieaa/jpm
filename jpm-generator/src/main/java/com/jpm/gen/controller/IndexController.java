package com.jpm.gen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: IndexController
 * @author: 李杰
 * @create: 2018-07-12 16:08
 **/
@Controller
public class IndexController {
    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }
}
