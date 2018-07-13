package com.jpm.gen.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: LayoutController
 * @author: 李杰
 * @create: 2018-07-12 16:08
 **/
@Controller
public class LayoutController {
    @RequestMapping(value = "layout")
    public String layout(){
        return "layout";
    }
}
