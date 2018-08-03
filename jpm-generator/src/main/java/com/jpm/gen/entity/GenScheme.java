package com.jpm.gen.entity;

import com.jpm.common.entity.DataEntity;
import org.hibernate.validator.constraints.Length;

/**
 * @description: 代码生成方案
 * @author: 李杰
 * @create: 2018-08-02 16:33
 **/
public class GenScheme extends DataEntity<GenScheme,String> {

    private static final long serialVersionUID = 1L;
    private String name; 	// 名称
    private String category;		// 分类
    private String packageName;		// 生成包路径
    private String moduleName;		// 生成模块名
    private String subModuleName;		// 生成子模块名
    private String functionName;		// 生成功能名
    private String functionNameSimple;		// 生成功能名（简写）
    private String functionAuthor;		// 生成功能作者
    private GenTable genTable;		// 业务表名



    public GenScheme() {
        super();
    }

    public GenScheme(String id){
        super(id);
    }

    @Length(min=1, max=200)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
    }

    public String getModuleName() {
        return moduleName;
    }

    public void setModuleName(String moduleName) {
        this.moduleName = moduleName;
    }

    public String getSubModuleName() {
        return subModuleName;
    }

    public void setSubModuleName(String subModuleName) {
        this.subModuleName = subModuleName;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getFunctionName() {
        return functionName;
    }

    public void setFunctionName(String functionName) {
        this.functionName = functionName;
    }

    public String getFunctionNameSimple() {
        return functionNameSimple;
    }

    public void setFunctionNameSimple(String functionNameSimple) {
        this.functionNameSimple = functionNameSimple;
    }

    public String getFunctionAuthor() {
        return functionAuthor;
    }

    public void setFunctionAuthor(String functionAuthor) {
        this.functionAuthor = functionAuthor;
    }

    public GenTable getGenTable() {
        return genTable;
    }

    public void setGenTable(GenTable genTable) {
        this.genTable = genTable;
    }
}
