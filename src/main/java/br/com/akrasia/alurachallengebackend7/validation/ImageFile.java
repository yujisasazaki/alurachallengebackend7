package br.com.akrasia.alurachallengebackend7.validation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = ImageFileValidator.class)
@Documented
public @interface ImageFile {

    String message() default "is not an image";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};    
}
