package com.jpm.common.anno.validator;

import com.jpm.common.validator.IntegerValidator;
import com.jpm.common.validator.NumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
@Retention(RUNTIME)
@Documented
@Constraint(validatedBy = { IntegerValidator.class })
public @interface Integer {
    String message() default "这不是有效的整数格式";
    /**
     * @return the regular expression to match
     */
    String regexp() default "^-?\\d+$";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    /**
     * Defines several {@link Size} annotations on the same element.
     *
     * @see Size
     */
    @Target({ METHOD, FIELD, ANNOTATION_TYPE, CONSTRUCTOR, PARAMETER })
    @Retention(RUNTIME)
    @Documented
    @interface List {

        Integer[] value();
    }

}
