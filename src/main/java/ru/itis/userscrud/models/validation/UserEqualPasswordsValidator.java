package ru.itis.userscrud.models.validation;

import ru.itis.userscrud.dto.UserRegFormDto;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.lang.reflect.Field;

public class UserEqualPasswordsValidator implements ConstraintValidator<UserEqualPasswords, Object> {
    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        if(!o.getClass().equals(UserRegFormDto.class)) {
            return false;
        }
        Field password;
        Field repassword;
        try {
            password = o.getClass().getDeclaredField("password");
            repassword = o.getClass().getDeclaredField("repassword");
        } catch (Exception e) {
            throw new IllegalStateException(e);
        }
        password.setAccessible(true);
        repassword.setAccessible(true);
        boolean result;
        try {
            result = password.get(o).equals(repassword.get(o));
        }catch (Exception e) {
            throw new IllegalStateException(e);
        }
        return result;
    }
}
