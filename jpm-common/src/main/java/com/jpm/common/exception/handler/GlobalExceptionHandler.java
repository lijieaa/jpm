package com.jpm.common.exception.handler;

import com.jpm.common.anno.advice.NoRslt;
import com.jpm.common.config.GlobalMsg;
import com.jpm.common.entity.ResultEntity;
import com.mysql.jdbc.exceptions.jdbc4.MySQLSyntaxErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.*;

/**
 * @description: 全局异常处理
 * @author: 李杰
 * @create: 2018-08-08 13:57
 **/
@ControllerAdvice
@ResponseBody
public class GlobalExceptionHandler {

    @Autowired
    GlobalMsg globalMsg;
    /*@ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResultEntity notFoundPage404() {
        return new ResultEntity(404,"没有找到资源","没有找到资源");
    }*/

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.OK)
    @NoRslt
    public ResultEntity methodArgumentNotValidException(MethodArgumentNotValidException e) {
        List<ObjectError> allErrors = e.getBindingResult().getAllErrors();
        List<Map<String,String>> errList= new ArrayList<Map<String, String>>();
        for (ObjectError error : allErrors) {
            FieldError err=(FieldError)error;
            String defaultMessage = err.getDefaultMessage();
            String field = err.getField();
            Map<String,String> errMap=new HashMap<String, String>();
            errMap.put(field,defaultMessage);
            errList.add(errMap);
        }
        return new ResultEntity(40001,globalMsg.getErrmsg().get("40001"),errList);
    }

    @ExceptionHandler(MySQLSyntaxErrorException.class)
    @ResponseStatus(HttpStatus.OK)
    @NoRslt
    public ResultEntity mySQLSyntaxErrorException(MySQLSyntaxErrorException e) {

        return new ResultEntity(40002,globalMsg.getErrmsg().get("40002"),null);
    }
}
