package ${packageName}.${moduleName}.controller;

import com.github.pagehelper.PageInfo;
import com.jpm.gen.utils.GenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.List;
import java.util.Map;

import ${packageName}.${moduleName}.entity.${ClassName}Entity;
import ${packageName}.${moduleName}.dao.${ClassName}Dao;
import ${packageName}.${moduleName}.service.${ClassName}Service;


/**
 * ${functionName}Controller
 * @author ${functionAuthor}
 * @version ${functionVersion}
 */
@Controller
@RequestMapping("${moduleName}/${className}")
public class ${ClassName}Controller {

    @Autowired
    ${ClassName}Service ${className}Service;

    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    @ResponseBody
    public ${ClassName}Entity get(@PathVariable(value="id") String id){
        ${ClassName}Entity entiy = ${className}Service.find(id);
        return entiy;
    }

    @RequestMapping(method = RequestMethod.GET,value = "page")
    @ResponseBody
    public PageInfo page(@RequestParam Map data){
        PageInfo pageInfo = ${className}Service.findPage(data);
        return pageInfo;
    }


    @RequestMapping(method = RequestMethod.GET,value = "list")
    @ResponseBody
    public List<${ClassName}Entity> list(@RequestParam Map data){
    List<${ClassName}Entity> list = ${className}Service.findAll(data);
        return list;
    }

        @RequestMapping(method = RequestMethod.POST)
        @ResponseBody
        public String save(@RequestBody ${ClassName}Entity entity){
            ${className}Service.add(entity);
            return "ok";
        }

        @RequestMapping(method = RequestMethod.PUT)
        @ResponseBody
        public String update(@RequestBody ${ClassName}Entity entity){
        ${className}Service.update(scheme);
        return "ok";
        }

        @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
        @ResponseBody
        public String delete(@PathVariable(value="id") String[] ids){
        ${className}Service.remove(ids);
        return "ok";
        }
        }
