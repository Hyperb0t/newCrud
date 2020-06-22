package ru.itis.userscrud.controllers.util;

import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;

public class ValidationErrorBuilder {

    public static ValidationError fromBindingErrors(Errors errors) {
        ValidationError error = new ValidationError("Validation failed. " + errors.getErrorCount() + " error(s)");
        for (ObjectError objectError : errors.getGlobalErrors()) {
            error.addValidationError(objectError.getDefaultMessage());
        }
        errors.getFieldErrors().stream().forEach(e ->
                error.addValidationError(e.getField() + ": " + e.getRejectedValue() + ": " + e.getDefaultMessage()));

        return error;
    }
}