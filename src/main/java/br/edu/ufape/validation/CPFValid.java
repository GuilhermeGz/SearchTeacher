package br.edu.ufape.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@java.lang.annotation.Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = CPFValidator.class)
public @interface CPFValid {
    String message() default "{br.edu.ufape.bcc.validation.CPFvalidator.message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}