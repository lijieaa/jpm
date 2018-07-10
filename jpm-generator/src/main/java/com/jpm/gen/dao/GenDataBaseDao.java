package com.jpm.gen.dao;

import com.jpm.gen.entity.GenTable;

import java.util.List;

public interface GenDataBaseDao {
    public List<GenTable> findTableList(GenTable table);
}
