package com.jpm.common.validator;

import com.jpm.common.anno.validator.IdCard;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 身份证验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class IdCardValidator implements ConstraintValidator<IdCard,String> {

    private String regexp;

    public void initialize(IdCard constraintAnnotation) {
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
