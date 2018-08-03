package com.jpm.gen.service;

import com.jpm.common.utils.StringUtils;
import com.jpm.gen.dao.GenDataBaseDao;
import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;
import com.jpm.gen.utils.GenUtils;
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


    /**
     * 获取物理数据表列表
     * @param genTable
     * @return
     */
    public GenTable getTableFormDb(GenTable genTable){
        // 如果有表名，则获取物理表
        if (StringUtils.isNotBlank(genTable.getName())){

            List<GenTable> list = genDataBaseDao.findTableList(genTable);
            if (list.size() > 0){

                // 如果是新增，初始化表属性
                if (StringUtils.isBlank((String)genTable.getId())){
                    genTable = list.get(0);
                    // 设置字段说明
                    if (StringUtils.isBlank(genTable.getComments())){
                        genTable.setComments(genTable.getName());
                    }
                    genTable.setClassName(StringUtils.toCapitalizeCamelCase(genTable.getName()));
                }

                // 添加新列
                List<GenTableColumn> columnList = genDataBaseDao.findTableColumnList(genTable);
                for (GenTableColumn column : columnList){
                    boolean b = false;
                    for (GenTableColumn e : genTable.getCols()){
                        if (e.getName().equals(column.getName())){
                            b = true;
                        }
                    }
                    if (!b){
                        genTable.getCols().add(column);
                    }
                }

                // 删除已删除的列
                /*for (GenTableColumn e : genTable.getCols()){
                    boolean b = false;
                    for (GenTableColumn column : columnList){
                        if (column.getName().equals(e.getName())){
                            b = true;
                        }
                    }
                    if (!b){
                        e.setDelFlag(GenTableColumn.DEL_FLAG_DELETE);
                    }
                }*/

                // 获取主键
                genTable.setPks(genDataBaseDao.findTablePK(genTable));

                // 初始化列属性字段
                GenUtils.initColumnField(genTable);

            }
        }
        return genTable;
    }
}
