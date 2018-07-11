package com.jpm.gen.controller;

import com.jpm.gen.entity.GenTable;
import com.jpm.gen.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @description: 代码生成controller
 * @author: 李杰
 * @create: 2018-07-10 10:45
 **/
@Controller
@RequestMapping(value = "gen")
public class GenTableController {

    @Autowired
    GenTableService genTableService;

    @RequestMapping(value = "table_list")
    @ResponseBody
    public List<GenTable> findTableList(GenTable genTable){
        return genTableService.findTableList(genTable);
    }
    @RequestMapping(value = "index")
    public String index(){
        return "ace/index";
    }
}
