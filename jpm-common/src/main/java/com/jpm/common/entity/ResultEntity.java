package com.jpm.common.entity;

/**
 * @description: http返回信息
 * @author: 李杰
 * @create: 2018-08-08 13:46
 **/
public class  ResultEntity<T> {
    private Integer errcode;//错误代码，自定义
    private String errmsg;//错误信息

    public ResultEntity() {
    }

    public ResultEntity(Integer errcode, String errmsg, T rslt) {
        this.errcode = errcode;
        this.errmsg = errmsg;
        this.rslt = rslt;
    }

    private T rslt;//实际内容

    public Integer getErrcode() {
        return errcode;
    }

    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }

    public String getErrmsg() {
        return errmsg;
    }

    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }

    public T getRslt() {
        return rslt;
    }

    public void setRslt(T rslt) {
        this.rslt = rslt;
    }
}
