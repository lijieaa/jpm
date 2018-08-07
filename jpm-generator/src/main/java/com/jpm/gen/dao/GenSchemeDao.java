package com.jpm.gen.dao;

import com.jpm.common.dao.CrudDao;
import com.jpm.gen.entity.GenScheme;

import java.util.List;
import java.util.Map;

/**
 * @description: 代码生成方案Dao
 * @author: 李杰
 * @create: 2018-08-02 16:43
 **/
public interface GenSchemeDao extends CrudDao<GenScheme,String> {

    public List<GenScheme> test(Map data);
}
