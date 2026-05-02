package com.innoventes.test.app.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import com.innoventes.test.app.validator.EvenNumberOrZeroValidator;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EvenNumberOrZeroValidator.class)
public @interface EvenNumberOrZero {
	String message() default "Value must be even or Zero.";
	Class<?>[] group() default{};
	Class<? extends Payload>[] payload() default {};

}
