package com.jpm.common.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @description: 全局配置
 * @author: 李杰
 * @create: 2018-08-08 14:53
 **/
@ConfigurationProperties
@Component
public class GlobalConfig {

    private Map<String, String> errmsg = new LinkedHashMap<String,String>();

    public Map<String, String> getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(Map<String, String> errmsg) {
        this.errmsg = errmsg;
    }


    public Map<String, Map> getValidator() {
        return validator;
    }

    public void setValidator(Map<String, Map> validator) {
        this.validator = validator;
    }

    //验证器
    private Map<String, Map> validator = new LinkedHashMap<String,Map>();



    //java类型
    private Map<String, String> javaType = new LinkedHashMap<String, String>();
    //查询类型
    private Map<String, String> queryType = new LinkedHashMap<String,String>();

    //显示类型
    private Map<String, String> showType = new LinkedHashMap<String,String>();

    public Map<String, String> getShowType() {
        return showType;
    }

    public void setShowType(Map<String, String> showType) {
        this.showType = showType;
    }

    public Map<String, String> getQueryType() {
        return queryType;
    }

    public void setQueryType(Map<String, String> queryType) {
        this.queryType = queryType;
    }

    public Map<String, String> getJavaType() {
        return javaType;
    }

    public void setJavaType(Map<String, String> javaType) {
        this.javaType = javaType;
    }

    public Map<String, String> getFtl() {
        return ftl;
    }

    public void setFtl(Map<String, String> ftl) {
        this.ftl = ftl;
    }

    //查询类型
    private Map<String, String> ftl = new LinkedHashMap<String,String>();


}
