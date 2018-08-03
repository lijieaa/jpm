package com.jpm.gen.controller;

import com.github.pagehelper.PageInfo;
import com.jpm.gen.entity.GenScheme;
import com.jpm.gen.service.GenSchemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @description: 代码生成方案controller
 * @author: 李杰
 * @create: 2018-08-02 16:47
 **/
@Controller
@RequestMapping("gen/scheme")
public class GenSchemeController {

    @Autowired
    GenSchemeService genSchemeService;

    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    @ResponseBody
    public GenScheme get(@PathVariable(value="id") String id){
        GenScheme entiy = genSchemeService.get(id);
        return entiy;
    }

    @RequestMapping(method = RequestMethod.GET,value = "page")
    @ResponseBody
    public PageInfo page(GenScheme entiy, int num, int size){
        PageInfo pageInfo = genSchemeService.findPage(entiy,num,size);
        return pageInfo;
    }


    @RequestMapping(method = RequestMethod.GET,value = "list")
    @ResponseBody
    public List<GenScheme> list(GenScheme entiy){
        List<GenScheme> list = genSchemeService.findAll(entiy);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody GenScheme scheme){
        genSchemeService.add(scheme);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody GenScheme scheme){
        genSchemeService.update(scheme);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    @ResponseBody
    public String delete(@PathVariable(value="id") String[] ids){
        genSchemeService.remove(ids);
        return "ok";
    }
}
