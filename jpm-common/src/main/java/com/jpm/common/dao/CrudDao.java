package com.jpm.common.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @description: CrudDao
 * @author: 李杰
 * @create: 2018-08-02 15:40
 **/
public interface CrudDao<T,PK extends Serializable> extends BaseDao {
    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T select(PK id);

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T select(T entity);


    /**
     * 查询所有数据列表
     * @param data
     * @return
     */
    public List<T> selectAll(Map data);


    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int insert(T entity);

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(T entity);

    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int delete(PK[] ids);
}
