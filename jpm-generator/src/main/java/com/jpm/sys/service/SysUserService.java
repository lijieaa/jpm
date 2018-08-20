package com.jpm.sys.service;

import java.util.List;
import java.util.Map;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.jpm.common.service.CrudService;
import com.jpm.sys.entity.SysUserEntity;
import com.jpm.sys.dao.SysUserDao;

/**
 * 系统用户管理Service
 * @author 李杰
 * @version 2018-08-20
 */
@Service
@Transactional(readOnly = true)
public class SysUserService extends CrudService<SysUserDao, SysUserEntity,String> {

	@Override
    public SysUserEntity find(String id) {
        return super.find(id);
    }

    @Override
    public SysUserEntity find(SysUserEntity entity) {
        return super.find(entity);
    }


    @Autowired
    PasswordEncoder encoder;


    @Transactional(readOnly = false)
    @Override
    public int add(SysUserEntity entity) {
        entity.setPassword(encoder.encode(entity.getPassword()));
        return super.add(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public int update(SysUserEntity entity) {
        return super.update(entity);
    }

    @Transactional(readOnly = false)
    @Override
    public int remove(String[] ids) {
        return super.remove(ids);
    }

    @Override
    public PageInfo findPage(Map data) {
        return super.findPage(data);
    }

    @Override
    public PageInfo findJgGridPage(Map data) {
        return super.findJgGridPage(data);
    }

    @Override
    public List<SysUserEntity> findAll(Map data) {
        return super.findAll(data);
    }


    /**
     * 登录
     * @param username
     * @return
     */
    public SysUserEntity findByUsername(String username){
        return dao.selectByUsername(username);
    }
}