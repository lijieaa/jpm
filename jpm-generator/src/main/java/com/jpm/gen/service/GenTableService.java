package com.jpm.gen.service;

import com.jpm.gen.dao.GenDataBaseDao;
import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @description: 业务代码生成业务
 * @author: 李杰
 * @create: 2018-07-10 10:42
 **/
@Service
public class GenTableService {

    @Autowired
    GenDataBaseDao genDataBaseDao;

    /**
     * 查询当前连接数据库所有表
     * @param table
     * @return
     */
    public List<GenTable> findTableList(GenTable table){
        return genDataBaseDao.findTableList(table);
    }

    /**
     * 获取表字段
     * @param table
     * @return
     */
    public List<GenTableColumn> findTableColumnList(GenTable table){
        return genDataBaseDao.findTableColumnList(table);
    }
}
