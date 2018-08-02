package com.jpm.gen.controller;

import com.jpm.common.utils.StringUtils;
import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;
import com.jpm.gen.service.GenTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @description: 代码生成controller
 * @author: 李杰
 * @create: 2018-07-10 10:45
 **/
@Controller
@RequestMapping(value = "gen")
@ConfigurationProperties  // 配置文件中的前缀
public class GenTableController {

    //java类型
    private Map<String, String> javaType = new LinkedHashMap<String, String>();
    //查询类型
    private Map<String, String> queryType = new LinkedHashMap<String,String>();

    //显示类型
    private Map<String, String> showType = new LinkedHashMap<String,String>();

    public Map<String, String> getValidator() {
        return validator;
    }

    public void setValidator(Map<String, String> validator) {
        this.validator = validator;
    }

    //验证器
    private Map<String, String> validator = new LinkedHashMap<String,String>();

    public Map<String, String> getShowType() {
        return showType;
    }

    public void setShowType(Map<String, String> showType) {
        this.showType = showType;
    }

    public Map<String, String> getQueryType() {
        return queryType;
    }

    public void setQueryType(Map<String, String> queryType) {
        this.queryType = queryType;
    }





    public Map<String, String> getJavaType() {
        return javaType;
    }

    public void setJavaType(Map<String, String> javaType) {
        this.javaType = javaType;
    }




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
    Map phy_data(@RequestParam(value = "tname",required = true)String tname){
        GenTable genTable=new GenTable();
        genTable.setName(tname);
        GenTable tableFormDb = genTableService.getTableFormDb(genTable);

        Map data=new HashMap();
        data.put("table",tableFormDb);
        data.put("javaType",javaType);
        data.put("queryType",queryType);
        data.put("showType",showType);
        data.put("validator",validator);
        return data;
    }


}
