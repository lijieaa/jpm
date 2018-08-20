package com.jpm.sys.controller;

import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;
import java.util.Map;
import com.jpm.common.entity.JqGridEntity;

import com.jpm.sys.entity.SysUserEntity;
import com.jpm.sys.service.SysUserService;


/**
 * 系统用户管理Controller
 * @author 李杰
 * @version 2018-08-20
 */
@RestController
@RequestMapping("api/sys/sys_user")
public class SysUserRestController {

    @Autowired
    SysUserService sysUserService;

    @RequestMapping(method = RequestMethod.GET,value = "{id}")
    public SysUserEntity get(@PathVariable(value="id") String id){
        SysUserEntity entiy = sysUserService.find(id);
        return entiy;
    }

    @RequestMapping(method = RequestMethod.GET,value = "page")
    public PageInfo page(@RequestParam Map data){
        PageInfo pageInfo = sysUserService.findPage(data);
        return pageInfo;
    }


    /**
     * jggrid表格分页
     * @param data
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "jggrid")
    public JqGridEntity<SysUserEntity> jqGrid(@RequestParam Map data){
    PageInfo pageInfo = sysUserService.findJgGridPage(data);
    JqGridEntity<SysUserEntity> gridEntity=new JqGridEntity<SysUserEntity>(pageInfo.getPageNum(),pageInfo.getPages(),pageInfo.getTotal(),pageInfo.getList());
        return gridEntity;
        }


    @RequestMapping(method = RequestMethod.GET,value = "list")
    public List<SysUserEntity> list(@RequestParam Map data){
    List<SysUserEntity> list = sysUserService.findAll(data);
        return list;
    }

        @RequestMapping(method = RequestMethod.POST)
        public int save(@RequestBody @Valid SysUserEntity entity){

            return sysUserService.add(entity);
        }

        @RequestMapping(method = RequestMethod.PUT)
        public int update(@RequestBody @Valid SysUserEntity entity){

        return sysUserService.update(entity);
        }

        @RequestMapping(method = RequestMethod.DELETE,value = "{id}")
        public int delete(@PathVariable(value="id") String[] ids){

        return sysUserService.remove(ids);
        }
        }
