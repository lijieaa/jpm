package com.jpm.common.validator;

import com.jpm.common.anno.validator.Date;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 日期验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class DateValidator implements ConstraintValidator<Date,String> {

    private String regexp;

    public void initialize(Date constraintAnnotation) {
        this.regexp = constraintAnnotation.regexp();
    }

    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value==null){return true;}
        if( value.matches(regexp)){
            return true;
        }
        return false;
    }
}
