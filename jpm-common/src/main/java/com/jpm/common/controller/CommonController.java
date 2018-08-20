package com.jpm.common.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @description: 通用controller
 * @author: 李杰
 * @create: 2018-08-20 16:10
 **/
@Controller
public class CommonController {

    @RequestMapping("login")
    public String login() {
        return "login";
    }
}
