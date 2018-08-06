package com.jpm.common.validator;

import com.jpm.common.anno.validator.Digits;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 日期验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class DigitsValidator implements ConstraintValidator<Digits,String> {

    private String regexp;

    public void initialize(Digits constraintAnnotation) {
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
