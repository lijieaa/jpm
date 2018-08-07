package com.jpm.gen.controller;

import com.github.pagehelper.PageInfo;
import com.jpm.gen.dao.GenSchemeDao;
import com.jpm.gen.entity.GenScheme;
import com.jpm.gen.service.GenSchemeService;
import com.jpm.gen.utils.GenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

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


    @Autowired
    GenSchemeDao dao;

    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    @ResponseBody
    public GenScheme get(@PathVariable(value="id") String id){
        GenScheme entiy = genSchemeService.find(id);
        return entiy;
    }

    @RequestMapping(method = RequestMethod.GET,value = "page")
    @ResponseBody
    public PageInfo page(@RequestParam Map data){
        PageInfo pageInfo = genSchemeService.findPage(data);
        return pageInfo;
    }


    @RequestMapping(method = RequestMethod.GET,value = "list")
    @ResponseBody
    public List<GenScheme> list(@RequestParam Map data){
        List<GenScheme> list = genSchemeService.findAll(data);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseBody
    public String save(@RequestBody GenScheme scheme,Boolean isCode){
        //genSchemeService.add(scheme);
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

    @RequestMapping(method = RequestMethod.POST,value = "code")
    @ResponseBody
    public String code(@RequestBody GenScheme scheme) throws Exception {
        //genSchemeService.remove(ids);
        Writer out = new OutputStreamWriter(System.out);
        Map<String, Object> dataModel = GenUtils.getDataModel(scheme);
        GenUtils.render("dao.ftl",dataModel,out);
        return "ok";
    }
}
