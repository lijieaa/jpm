package com.jpm.gen.entity;

import com.jpm.common.entity.DataEntity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenTable extends DataEntity<GenTable> {

    private String name;//表名称
    private String comments;//表注释
    private String className;//实体名称
    private List<GenTableColumn> cols=new ArrayList<GenTableColumn>();//表列
    private List<Serializable> pks=new ArrayList<Serializable>();//主键

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<Serializable> getPks() {
        return pks;
    }

    public void setPks(List<Serializable> pks) {
        this.pks = pks;
    }



    public List<GenTableColumn> getCols() {
        return cols;
    }

    public void setCols(List<GenTableColumn> cols) {
        this.cols = cols;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }


}
