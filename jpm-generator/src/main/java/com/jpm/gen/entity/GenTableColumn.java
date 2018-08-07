package com.jpm.gen.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.collect.Lists;
import com.jpm.common.entity.DataEntity;
import com.jpm.common.utils.StringUtils;


import java.util.ArrayList;
import java.util.List;

/**
 * @description: 数据表属性
 * @author: 李杰
 * @create: 2018-07-30 14:13
 **/
public class GenTableColumn extends DataEntity<GenTableColumn,String> {
    private GenTable genTable;	// 归属表
    private String name; 		// 列名
    private String comments;	// 描述
    private String jdbcType;	// JDBC类型
    private String javaType;	// JAVA类型
    private String javaField;	// JAVA字段名
    private String isPk;		// 是否主键（1：主键）
    private String isNull;		// 是否可为空（1：可为空；0：不为空）
    private String isInsert;	// 是否为插入字段（1：插入字段）
    private String isEdit="0";		// 是否编辑字段（1：编辑字段）
    private String isList="0";		// 是否列表字段（1：列表字段）
    private String isQuery="0";		// 是否查询字段（1：查询字段）
    private String queryType="=";	// 查询方式（等于、不等于、大于、小于、范围、左LIKE、右LIKE、左右LIKE）
    private String showType="input";	// 字段生成方案（文本框、文本域、下拉框、复选框、单选框、字典选择、人员选择、部门选择、区域选择）
    private String dictType="";	// 字典类型
    private Integer sort;		// 排序（升序）

    public List<String> getValidator() {
        return validator;
    }

    public void setValidator(List<String> validator) {
        this.validator = validator;
    }

    private List<String> validator=new ArrayList<String>();	// 验证器

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

    public String getJdbcType() {
        return jdbcType;
    }

    public void setJdbcType(String jdbcType) {
        this.jdbcType = jdbcType;
    }

    public String getJavaType() {
        return javaType;
    }

    public void setJavaType(String javaType) {
        this.javaType = javaType;
    }

    public String getJavaField() {
        return javaField;
    }

    public void setJavaField(String javaField) {
        this.javaField = javaField;
    }

    public String getIsPk() {
        return isPk;
    }

    public void setIsPk(String isPk) {
        this.isPk = isPk;
    }

    public String getIsNull() {
        return isNull;
    }

    public void setIsNull(String isNull) {
        this.isNull = isNull;
    }

    public String getIsInsert() {
        return isInsert;
    }

    public void setIsInsert(String isInsert) {
        this.isInsert = isInsert;
    }

    public String getIsEdit() {
        return isEdit;
    }

    public void setIsEdit(String isEdit) {
        this.isEdit = isEdit;
    }

    public String getIsList() {
        return isList;
    }

    public void setIsList(String isList) {
        this.isList = isList;
    }

    public String getIsQuery() {
        return isQuery;
    }

    public void setIsQuery(String isQuery) {
        this.isQuery = isQuery;
    }

    public String getQueryType() {
        return queryType;
    }

    public void setQueryType(String queryType) {
        this.queryType = queryType;
    }

    public String getShowType() {
        return showType;
    }

    public void setShowType(String showType) {
        this.showType = showType;
    }

    public String getDictType() {
        return dictType;
    }

    public void setDictType(String dictType) {
        this.dictType = dictType;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public GenTable getGenTable() {
        return genTable;
    }

    public void setGenTable(GenTable genTable) {
        this.genTable = genTable;
    }


    /**
     * 获取简写Java字段
     * @return
     */
    public String getSimpleJavaField(){
        return StringUtils.substringBefore(getJavaField(), ".");
    }

    /**
     * 是否是基类字段
     * @return
     */
    public Boolean getIsNotBaseField(){
        return !StringUtils.equals(getSimpleJavaField(), "id")
                && !StringUtils.equals(getSimpleJavaField(), "remarks")
                && !StringUtils.equals(getSimpleJavaField(), "createBy")
                && !StringUtils.equals(getSimpleJavaField(), "createDate")
                && !StringUtils.equals(getSimpleJavaField(), "updateBy")
                && !StringUtils.equals(getSimpleJavaField(), "updateDate")
                && !StringUtils.equals(getSimpleJavaField(), "delFlag");
    }

    /**
     * 获取字符串长度
     * @return
     */
    public String getDataLength(){
        String[] ss = StringUtils.split(StringUtils.substringBetween(getJdbcType(), "(", ")"), ",");
        if (ss != null && ss.length == 1){// && "String".equals(getJavaType())){
            return ss[0];
        }
        return "0";
    }

    /**
     * 获取列注解列表
     * @return
     */
    @JsonIgnore
    public List<String> getAnnotationList(){
        List<String> list = Lists.newArrayList();
        // 导入Jackson注解
        if ("This".equals(getJavaType())){
            list.add("com.fasterxml.jackson.annotation.JsonBackReference");
        }
        if ("java.util.Date".equals(getJavaType())){
            list.add("com.fasterxml.jackson.annotation.JsonFormat(pattern = \"yyyy-MM-dd HH:mm:ss\")");
        }
        // 导入JSR303验证依赖包
        if (!"1".equals(getIsNull()) && !"String".equals(getJavaType())){
            list.add("javax.validation.constraints.NotNull(message=\""+getComments()+"不能为空\")");
        }
        else if (!"1".equals(getIsNull()) && "String".equals(getJavaType()) && !"0".equals(getDataLength())){
            list.add("org.hibernate.validator.constraints.Length(min=1, max="+getDataLength()
                    +", message=\""+getComments()+"长度必须介于 1 和 "+getDataLength()+" 之间\")");
        }
        else if ("String".equals(getJavaType()) && !"0".equals(getDataLength())){
            list.add("org.hibernate.validator.constraints.Length(min=0, max="+getDataLength()
                    +", message=\""+getComments()+"长度必须介于 0 和 "+getDataLength()+" 之间\")");
        }

        for (String v : validator) {
            if("email".equalsIgnoreCase(v)){
                list.add("javax.validation.constraints.Email(message = \""+getComments()+"邮箱格式不正确！\")");
            }else if("url".equalsIgnoreCase(v)){
                list.add("org.hibernate.validator.constraints.URL(message = \""+getComments()+"无效的URL！\")");
            }else if("date".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.Date(message = \""+getComments()+"日期格式不正确！\")");
            }else if("number".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.Number(message = \""+getComments()+"数值格式不正确！\")");
            }else if("integer".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.Integer(message = \""+getComments()+"整数格式不正确！\")");
            }else if("digits".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.Digits(message = \""+getComments()+"正整数格式不正确！\")");
            }else if("abc".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.Abc(message = \""+getComments()+"数字字母下划线格式不正确！\")");
            }else if("simplePhone".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.SimplePhone(message = \""+getComments()+"固定电话格式不正确！\")");
            }else if("phone".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.Phone(message = \""+getComments()+"手机号格式不正确！\")");
            }else if("zipCode".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.ZipCode(message = \""+getComments()+"邮政编码格式不正确！\")");
            }else if("ipv4".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.IPv4(message = \""+getComments()+"IPv4格式不正确！\")");
            }else if("ipv6".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.IPv6(message = \""+getComments()+"IPv6格式不正确！\")");
            }else if("qq".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.QQ(message = \""+getComments()+"QQ格式不正确！\")");
            }else if("idcard".equalsIgnoreCase(v)){
                list.add("com.jpm.common.anno.validator.IdCard(message = \""+getComments()+"身份证格式不正确！\")");
            }
        }
        return list;
    }


    /**
     * 获取简写Java类型
     * @return
     */
    public String getSimpleJavaType(){
        /*if ("This".equals(getJavaType())){
            return StringUtils.capitalize(genTable.getClassName());
        }*/
         String str = StringUtils.indexOf(getJavaType(), ".") != -1
                ? StringUtils.substringAfterLast(getJavaType(), ".")
                : getJavaType();
        //System.out.println(name+":"+str);
        return str;
    }


    /**
     * 获取简写列注解列表
     * @return
     */
    @JsonIgnore
    public List<String> getSimpleAnnotationList(){
        List<String> list = Lists.newArrayList();
        for (String ann : getAnnotationList()){
            list.add(StringUtils.substringAfterLast(ann, "."));
        }
        return list;
    }


    /**
     * 获取Java字段，如果是对象，则获取对象.附加属性1
     * @return
     */
    public String getJavaFieldId(){
        return StringUtils.substringBefore(getJavaField(), "|");
    }


}
