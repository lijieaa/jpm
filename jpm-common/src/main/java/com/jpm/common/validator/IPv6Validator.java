package com.jpm.common.validator;

import com.jpm.common.anno.validator.IPv6;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: IPv6验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class IPv6Validator implements ConstraintValidator<IPv6,String> {

    private String regexp;

    public void initialize(IPv6 constraintAnnotation) {
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
