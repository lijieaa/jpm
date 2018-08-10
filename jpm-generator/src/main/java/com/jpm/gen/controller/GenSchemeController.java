package com.jpm.gen.controller;

import com.github.pagehelper.PageInfo;
import com.jpm.common.entity.JqGridEntity;
import com.jpm.common.utils.StringUtils;
import com.jpm.gen.dao.GenSchemeDao;
import com.jpm.gen.entity.GenScheme;
import com.jpm.gen.service.GenSchemeService;
import com.jpm.gen.utils.GenUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
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
@RestController
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


    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    public GenScheme get(@PathVariable(value="id") String id){
        GenScheme entiy = genSchemeService.find(id);
        return entiy;
    }

    /**
     * 普通分页
     * @param data
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "page")
    public PageInfo page(@RequestParam Map data){
        PageInfo pageInfo = genSchemeService.findPage(data);
        return pageInfo;
    }

    /**
     * jggrid表格分页
     * @param data
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "jggrid")
    public JqGridEntity<GenScheme> jqGrid(@RequestParam Map data){
        PageInfo pageInfo = genSchemeService.findJgGridPage(data);
        JqGridEntity<GenScheme> gridEntity=new JqGridEntity<GenScheme>(pageInfo.getPageNum(),pageInfo.getPages(),pageInfo.getTotal(),pageInfo.getList());
        return gridEntity;
    }

    @RequestMapping(method = RequestMethod.GET,value = "list")
    public List<GenScheme> list(@RequestParam Map data){
        List<GenScheme> list = genSchemeService.findAll(data);
        return list;
    }

    @RequestMapping(method = RequestMethod.POST)
    public int save(@RequestBody GenScheme entity){

        return genSchemeService.add(entity);
    }

    @RequestMapping(method = RequestMethod.PUT)
    public int update(@RequestBody GenScheme entity){

        return genSchemeService.update(entity);
    }

    @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
    public int delete(@PathVariable(value="id") String[] ids){

        return genSchemeService.remove(ids);
    }

    @RequestMapping(method = RequestMethod.POST,value = "code")
    public void code(HttpServletResponse response,GenScheme entity) throws Exception {

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ZipOutputStream zip = new ZipOutputStream(outputStream);

        for (Map.Entry<String, String> entry : ftl.entrySet()) {
            if(entry.getKey().equals("mapper")){
                zip.putNextEntry(new ZipEntry("main/resources/mapper/"+entity.getModuleName()+File.separator+entity.getGenTable().getClassName()+"Dao.xml"));
            }else if(entry.getValue().indexOf("view")>-1){
                zip.putNextEntry(new ZipEntry("main/resources/templates/"+entity.getModuleName()+File.separator+StringUtils.toUnderScoreCase(entity.getGenTable().getClassName())+"_"+entry.getKey()+".html"));
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
