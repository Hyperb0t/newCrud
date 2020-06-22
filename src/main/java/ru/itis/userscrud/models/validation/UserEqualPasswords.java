package ru.itis.userscrud.models.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = UserEqualPasswordsValidator.class)
public @interface UserEqualPasswords {
    String message() default "Password and password repeat must be equal";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
