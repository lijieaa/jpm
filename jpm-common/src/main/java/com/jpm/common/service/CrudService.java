package com.jpm.common.service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jpm.common.dao.CrudDao;
import com.jpm.common.entity.DataEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.List;

/**
 * @description: CrudService基类
 * @author: 李杰
 * @create: 2018-08-02 15:53
 **/
@Transactional
public abstract class CrudService<D extends CrudDao<T ,PK>, T extends DataEntity<T,PK>,PK extends Serializable> extends BaseService {

    /**
     * 持久层对象
     */
    @Autowired
    protected D dao;

    /**
     * 获取单条数据
     * @param id
     * @return
     */
    public T get(PK id){
        return dao.select(id);
    };

    /**
     * 获取单条数据
     * @param entity
     * @return
     */
    public T get(T entity){
        return dao.select(entity);
    };


    /**
     * 查询所有数据列表
     * @param entity
     * @return
     */
    public List<T> getAll(T entity){
        return dao.selectAll(entity);
    };


    /**
     * 插入数据
     * @param entity
     * @return
     */
    public int add(T entity){
        return dao.insert(entity);
    };

    /**
     * 更新数据
     * @param entity
     * @return
     */
    public int update(T entity){
        return dao.update(entity);
    };


    /**
     * 批量删除
     * @param ids
     * @return
     */
    public int remove(PK[] ids){
        return dao.delete(ids);
    }

    /**
     * 分页查询
     * @param entiy 实体用于条件筛选
     * @param num 当前页
     * @param size 每页条数
     * @return
     */
    public PageInfo findPage(T entiy, int num, int size){
        PageHelper.startPage(num, size);
        List<T> list = dao.selectAll(entiy);
        PageInfo pageInfo = new PageInfo(list);
        return pageInfo;
    }

    /**
     * 查询所有
     * @param entiy 实体用于条件筛选
     * @return
     */
    public List<T> findAll(T entiy){
        List<T> list = dao.selectAll(entiy);
        return list;
    }
}