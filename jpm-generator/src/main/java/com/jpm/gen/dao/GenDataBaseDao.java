package com.jpm.gen.dao;

import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;

import java.io.Serializable;
import java.util.List;

public interface GenDataBaseDao {


    /**
     * 查询表列表
     * @param table
     * @return
     */
    public List<GenTable> findTableList(GenTable table);



    /**
     * 获取数据表字段
     * @param table
     * @return
     */
    public List<GenTableColumn> findTableColumnList(GenTable table);

    /**
     * 获取数据表主键
     * @param genTable
     * @return
     */
    List<Serializable> findTablePK(GenTable genTable);
}
