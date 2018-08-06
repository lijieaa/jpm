package com.jpm.common.validator;

import com.jpm.common.anno.validator.SimplePhone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 固定电话验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class SimplePhoneValidator implements ConstraintValidator<SimplePhone,String> {

    private String regexp;

    public void initialize(SimplePhone constraintAnnotation) {
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
