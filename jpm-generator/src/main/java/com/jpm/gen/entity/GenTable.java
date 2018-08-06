package com.jpm.gen.entity;

import com.jpm.common.entity.DataEntity;
import com.jpm.common.utils.StringUtils;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class GenTable extends DataEntity<GenTable,String> {

    private String name;//表名称
    private String comments;//表注释
    private String className;//实体名称
    private List<GenTableColumn> cols=new ArrayList<GenTableColumn>();//表列
    private List<String> pks=new ArrayList<String>();//主键

    public GenTable() {
    }

    public GenTable(String id) {
        super(id);
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public List<String> getPks() {
        return pks;
    }

    public void setPks(List<String> pks) {
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

    /**
     * 获取导入依赖包字符串
     * @return
     */
    public List<String> getImportList(){
        List<String> importList = new ArrayList<String>(); // 引用列表
        for (GenTableColumn column : getCols()){
            if (column.getIsNotBaseField() || ("1".equals(column.getIsQuery()) && "between".equals(column.getQueryType())
                    && ("createDate".equals(column.getSimpleJavaField()) || "updateDate".equals(column.getSimpleJavaField())))){
                // 导入类型依赖包， 如果类型中包含“.”，则需要导入引用。
                if (StringUtils.indexOf(column.getJavaType(), ".") != -1 && !importList.contains(column.getJavaType())){
                    importList.add(column.getJavaType());
                }
            }
            if (column.getIsNotBaseField()){
                // 导入JSR303、Json等依赖包
                for (String ann : column.getAnnotationList()){
                    if (!importList.contains(StringUtils.substringBeforeLast(ann, "("))){
                        importList.add(StringUtils.substringBeforeLast(ann, "("));
                    }
                }
            }
        }
        // 如果有子表，则需要导入List相关引用
        /*if (getChildList() != null && getChildList().size() > 0){
            if (!importList.contains("java.util.List")){
                importList.add("java.util.List");
            }
            if (!importList.contains("com.google.common.collect.Lists")){
                importList.add("com.google.common.collect.Lists");
            }
        }*/
        return importList;
    }


}
