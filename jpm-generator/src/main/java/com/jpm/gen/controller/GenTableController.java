package com.jpm.gen.controller;

import com.jpm.common.utils.StringUtils;
import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;
import com.jpm.gen.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @RequestMapping(value = "list")
    public String index(Model model,GenTable genTable){
        List<GenTable> tableList = genTableService.findTableList(genTable);
        model.addAttribute("tables",tableList);
        return "gen/list";
    }

    /**
     * 获取物理数据
     * @param tname
     * @return
     */
    @RequestMapping(value = "phy_data",method = RequestMethod.GET)
    public @ResponseBody
    GenTable getFields(@RequestParam(value = "tname",required = true)String tname){
        GenTable genTable=new GenTable();
        genTable.setName(tname);
        GenTable tableFormDb = genTableService.getTableFormDb(genTable);
        return tableFormDb;
    }


}
