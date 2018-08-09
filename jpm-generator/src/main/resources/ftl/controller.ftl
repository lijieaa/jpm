package ${packageName}.${moduleName}.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import com.jpm.common.entity.JqGridEntity;

import ${packageName}.${moduleName}.entity.${ClassName}Entity;
import ${packageName}.${moduleName}.service.${ClassName}Service;


/**
 * ${functionName}Controller
 * @author ${functionAuthor}
 * @version ${functionVersion}
 */
@RestController
@RequestMapping("${moduleName}/${className}")
public class ${ClassName}Controller {

    @Autowired
    ${ClassName}Service ${className}Service;

    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    public ${ClassName}Entity get(@PathVariable(value="id") String id){
        ${ClassName}Entity entiy = ${className}Service.find(id);
        return entiy;
    }

    @RequestMapping(method = RequestMethod.GET,value = "page")
    public PageInfo page(@RequestParam Map data){
        PageInfo pageInfo = ${className}Service.findPage(data);
        return pageInfo;
    }


    /**
     * jggrid表格分页
     * @param data
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "jggrid")
    public JqGridEntity<${ClassName}Entity> jqGrid(@RequestParam Map data){
    PageInfo pageInfo = ${className}Service.findJgGridPage(data);
    JqGridEntity<${ClassName}Entity> gridEntity=new JqGridEntity<${ClassName}Entity>(pageInfo.getPageNum(),pageInfo.getPages(),pageInfo.getTotal(),pageInfo.getList());
        return gridEntity;
        }


    @RequestMapping(method = RequestMethod.GET,value = "list")
    public List<${ClassName}Entity> list(@RequestParam Map data){
    List<${ClassName}Entity> list = ${className}Service.findAll(data);
        return list;
    }

        @RequestMapping(method = RequestMethod.POST)
        public int save(@RequestBody @Valid ${ClassName}Entity entity){

            return ${className}Service.add(entity);
        }

        @RequestMapping(method = RequestMethod.PUT)
        public int update(@RequestBody @Valid ${ClassName}Entity entity){

        return ${className}Service.update(entity);
        }

        @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
        public int delete(@PathVariable(value="id") String[] ids){

        return ${className}Service.remove(ids);
        }
        }
