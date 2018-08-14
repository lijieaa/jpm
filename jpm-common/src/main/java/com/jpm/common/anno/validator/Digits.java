package com.jpm.common.anno.validator;

import com.jpm.common.validator.DigitsValidator;

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
@Constraint(validatedBy = { DigitsValidator.class })
public @interface Digits {
    String message() default "这不是有效的正整数格式";
    /**
     * @return the regular expression to match
     */
    String regexp() default "^\\+?[1-9][0-9]*$";

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

        Digits[] value();
    }

}
