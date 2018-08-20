package com.jpm.common.validator;

import com.jpm.common.anno.validator.Abc;
import com.jpm.common.anno.validator.Date;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @description: 字母数字下划线验证器
 * @author: 李杰
 * @create: 2018-08-06 15:13
 **/
public class AbcValidator implements ConstraintValidator<Abc,String> {

    private String regexp;

    public void initialize(Abc constraintAnnotation) {
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
