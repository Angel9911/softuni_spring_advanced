package com.example.springsecurity.model.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // will be saved on Runtime
@Target(ElementType.FIELD)
@Constraint(validatedBy = YearPastOrPresentValidator.class) // will execute the Validation itself
public @interface YearInPastOrPresent {

    String message() default "Invalid year"; // @Annotation message

    int minYear(); // @Annotation input parameter, exmpl. @YearInPa..(min = 1930)

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
