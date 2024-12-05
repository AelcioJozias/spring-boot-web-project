package com.jozias.web.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class NameValidator implements ConstraintValidator<Name, String> {

    @Override
    public void initialize(Name constraintAnnotation) {
    }

    @Override
    public boolean isValid(String nome, ConstraintValidatorContext context) {
        if (nome == null || nome.trim().isEmpty()) {
            return false;
        }

        String[] nomes = nome.trim().split("\\s+");
        if (nomes.length < 2) {
            return false;
        }

        for (String n : nomes) {
            if (!Character.isUpperCase(n.charAt(0)) || !n.substring(1).equals(n.substring(1).toLowerCase())) {
                return false;
            }
        }

        return true;
    }
}