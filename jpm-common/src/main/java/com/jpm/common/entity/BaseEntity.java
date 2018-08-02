package com.jpm.common.entity;

import java.io.Serializable;

/**
 * @description: 所有实体基类
 * @author: 李杰
 * @create: 2018-07-30 14:16
 **/
public abstract  class BaseEntity<T> implements Serializable {
    private String id;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
