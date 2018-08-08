package com.jpm.common.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

/**
 * @description: 数据实体基类
 * @author: 李杰
 * @create: 2018-07-30 14:18
 **/
public abstract class DataEntity<T,PK extends Serializable> extends BaseEntity<T,PK>{
    protected String remarks;	// 备注
    protected UserEntity createBy;	// 创建者
    protected Date createDate;	// 创建日期
    protected UserEntity updateBy;	// 更新者

    public UserEntity getCreateBy() {
        return createBy;
    }

    public void setCreateBy(UserEntity createBy) {
        this.createBy = createBy;
    }

    public UserEntity getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(UserEntity updateBy) {
        this.updateBy = updateBy;
    }

    protected Date updateDate;	// 更新日期

    public DataEntity() {
    }

    public DataEntity(PK id) {
        super(id);
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }



    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}
