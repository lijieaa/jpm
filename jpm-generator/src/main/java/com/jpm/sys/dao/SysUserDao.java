package com.jpm.sys.dao;

import com.jpm.common.dao.CrudDao;
import com.jpm.sys.entity.SysUserEntity;

/**
 * 系统用户管理DAO接口
 * @author 李杰
 * @version 2018-08-20
 */
public interface SysUserDao extends CrudDao<SysUserEntity,String> {
    /**
     * 登录
     * @param username
     * @return
     */
    public SysUserEntity selectByUsername(String username);
}