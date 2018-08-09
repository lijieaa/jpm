package com.jpm.common.entity;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: jqgrid数据表格返回实体
 * @author: 李杰
 * @create: 2018-08-09 09:44
 **/
public class JqGridEntity<T> {

    private int page;//当前页
    private int total;//总页数

    public JqGridEntity() {
    }

    private long records;//总记录数
    private List<T> rows=new ArrayList<T>();//数据条目

    public JqGridEntity(int page, int total, long records, List<T> rows) {
        this.page = page;
        this.total = total;
        this.records = records;
        this.rows = rows;
    }


    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
