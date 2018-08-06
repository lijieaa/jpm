package com.jpm.common.validator;

import com.jpm.common.anno.validator.Phone;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 手机号验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class PhoneValidator implements ConstraintValidator<Phone,String> {

    private String regexp;

    public void initialize(Phone constraintAnnotation) {
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
