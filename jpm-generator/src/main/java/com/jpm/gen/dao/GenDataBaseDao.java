package com.jpm.gen.dao;

import com.jpm.gen.entity.GenTable;
import com.jpm.gen.entity.GenTableColumn;

import java.util.List;

public interface GenDataBaseDao {
    public List<GenTable> findTableList(GenTable table);

    public List<GenTableColumn> findTableColumnList(GenTable table);
}
