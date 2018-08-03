package com.jpm.common.entity;

import java.io.Serializable;

/**
 * @description: 所有实体基类
 * @author: 李杰
 * @create: 2018-07-30 14:16
 **/
public abstract class BaseEntity<T,PK extends Serializable> implements Serializable {
    private PK id;

    public BaseEntity() {
    }

    public BaseEntity(PK id) {
        this.id = id;
    }

    public PK getId() {
        return id;
    }

    public void setId(PK id) {
        this.id = id;
    }
}
