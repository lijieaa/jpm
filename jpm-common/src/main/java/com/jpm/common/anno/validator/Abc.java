package com.jpm.common.anno.validator;

import com.jpm.common.validator.AbcValidator;
import com.jpm.common.validator.DateValidator;

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
@Constraint(validatedBy = { AbcValidator.class })
public @interface Abc {
    String message() default "字母数字下划线";
    /**
     * @return the regular expression to match
     */
    String regexp() default "^[0-9a-zA-Z_]{1,}$";

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

        Abc[] value();
    }

}
