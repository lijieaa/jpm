package com.jpm.common.validator;

import com.jpm.common.anno.validator.IPv4;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: IPv4验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class IPv4Validator implements ConstraintValidator<IPv4,String> {

    private String regexp;

    public void initialize(IPv4 constraintAnnotation) {
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
