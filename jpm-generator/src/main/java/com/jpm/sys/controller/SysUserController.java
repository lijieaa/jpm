package com.jpm.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * 系统用户管理Controller
 * @author 李杰
 * @version 2018-08-20
 */
@Controller
@RequestMapping("sys/sys_user")
public class SysUserController {
    @RequestMapping(method = RequestMethod.GET, value = "list")
    public String list() {
        return "sys/sys_user_list";
    }

    @RequestMapping(method = RequestMethod.GET, value = "form")
    public String add() {
        return "sys/sys_user_form";
    }

    @RequestMapping(method = RequestMethod.GET, value = "detail")
    public String detail() {
        return "sys/sys_user_detail";
    }
}
