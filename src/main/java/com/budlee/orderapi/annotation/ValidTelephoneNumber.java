package com.budlee.orderapi.annotation;

import com.budlee.orderapi.annotation.validator.TelephoneNumberValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = TelephoneNumberValidator.class)
public @interface ValidTelephoneNumber {
    String message() default "Invalid telephone number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
