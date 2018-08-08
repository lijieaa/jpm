package com.jpm.gen.controller;

import com.github.pagehelper.PageInfo;
import com.jpm.common.utils.StringUtils;
import com.jpm.gen.dao.GenSchemeDao;
import com.jpm.gen.entity.GenScheme;
import com.jpm.gen.service.GenSchemeService;
import com.jpm.gen.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * @description: 代码生成方案controller
 * @author: 李杰
 * @create: 2018-08-02 16:47
 **/
@Controller
@RequestMapping("gen/scheme")
@ConfigurationProperties
public class GenSchemeController {


    public Map<String, String> getFtl() {
        return ftl;
    }

    public void setFtl(Map<String, String> ftl) {
        this.ftl = ftl;
    }

    //查询类型
    private Map<String, String> ftl = new LinkedHashMap<String,String>();

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
    public String save(@RequestBody GenScheme entity){
        genSchemeService.add(entity);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.PUT)
    @ResponseBody
    public String update(@RequestBody GenScheme entity){
        genSchemeService.update(entity);
        return "ok";
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    @ResponseBody
    public int delete(@PathVariable(value="id") String[] ids){

        return genSchemeService.remove(ids);
    }

    @RequestMapping(method = RequestMethod.POST,value = "code")
    @ResponseBody
    public void code(HttpServletResponse response,@RequestBody GenScheme entity) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (Map.Entry<String, String> entry : ftl.entrySet()) {
            if(entry.getKey().equals("mapper")){
                zip.putNextEntry(new ZipEntry("main/resources/mapper/"+entity.getModuleName()+File.separator+entity.getGenTable().getClassName()+"Dao.xml"));
            }else{
                zip.putNextEntry(new ZipEntry("main/java/com/jpm/"+entity.getModuleName()+File.separator+entry.getKey()+ File.separator+entity.getGenTable().getClassName()+StringUtils.capitalize(entry.getKey()) +".java"));
            }

            StringWriter sw = new StringWriter();
            Map<String, Object> dataModel = GenUtils.getDataModel(entity);
            GenUtils.render(entry.getValue()+".ftl",dataModel,sw);
            IOUtils.write(sw.toString(),zip,"UTF-8");
            IOUtils.closeQuietly(sw);
            zip.closeEntry();
        }




        IOUtils.closeQuietly(zip);
        byte[] data=outputStream.toByteArray();
        response.reset();
        response.setHeader("Content-Disposition", "attachment; filename="+entity.getModuleName());
        response.addHeader("Content-Length", "" + data.length);
        response.setContentType("application/octet-stream; charset=UTF-8");

        IOUtils.write(data, response.getOutputStream());
    }
}
