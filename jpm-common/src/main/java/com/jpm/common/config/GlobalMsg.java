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
public class GlobalMsg {

    private Map<String, String> errmsg = new LinkedHashMap<String,String>();

    public Map<String, String> getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(Map<String, String> errmsg) {
        this.errmsg = errmsg;
    }


}
