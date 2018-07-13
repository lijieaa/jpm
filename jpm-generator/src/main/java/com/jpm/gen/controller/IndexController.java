package com.jpm.gen.controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 首页controller
 * @author: 李杰
 * @create: 2018-07-12 16:19
 **/
public class IndexController {

    @RequestMapping(value = "index")
    public String index(){
        return "index";
    }

}
