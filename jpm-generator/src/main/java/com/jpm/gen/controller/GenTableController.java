package com.jpm.gen.controller;

import com.jpm.common.utils.StringUtils;
import com.jpm.gen.entity.GenTable;
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

    @RequestMapping(value = "table_list")
    @ResponseBody
    public List<GenTable> findTableList(GenTable genTable){
        return genTableService.findTableList(genTable);
    }

    @RequestMapping(value = "list")
    public String index(Model model,GenTable genTable){
        List<GenTable> tableList = genTableService.findTableList(genTable);
        model.addAttribute("tables",tableList);
        return "gen/list";
    }

    /**
     * 表基本信息
     * @param tname
     * @return
     */
    @RequestMapping(value = "basic",method = RequestMethod.GET)
    public @ResponseBody
    Map basic(@RequestParam(value = "tname",required = true)String tname){
        GenTable genTable=new GenTable();
        genTable.setName(tname);
        List<GenTable> tableList = genTableService.findTableList(genTable);
        GenTable genTable1 = tableList.get(0);
        Map data=new HashMap();
       data.put("tname",genTable1.getName());
       data.put("comments",genTable1.getComments());
       data.put("ename",StringUtils.toCapitalizeCamelCase(genTable.getName()));
        return data;
    }


}
