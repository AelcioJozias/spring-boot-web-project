package com.jozias.web.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;


public class CPFValidator implements ConstraintValidator<CPF, String> {

    @Override
    public void initialize(CPF constraintAnnotation) {
        // Inicialização, caso necessário
    }

    @Override
    public boolean isValid(String cpf, ConstraintValidatorContext context) {
        if (cpf == null || cpf.isEmpty()) {
            return true;
        }

        cpf = cpf.replaceAll("[^\\d]", ""); // Remove caracteres não numéricos

        if (cpf.length() != 11 || cpf.matches("(\\d)\\1{10}")) {
            return false; // Tamanho inválido ou todos os dígitos iguais
        }

        try {
            int sum = 0;
            for (int i = 0; i < 9; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (10 - i);
            }
            int firstVerifier = 11 - (sum % 11);
            if (firstVerifier >= 10) {
                firstVerifier = 0;
            }

            // Cálculo do segundo dígito verificador
            sum = 0;
            for (int i = 0; i < 10; i++) {
                sum += Character.getNumericValue(cpf.charAt(i)) * (11 - i);
            }
            int secondVerifier = 11 - (sum % 11);
            if (secondVerifier >= 10) {
                secondVerifier = 0;
            }

            return firstVerifier == Character.getNumericValue(cpf.charAt(9)) &&
                    secondVerifier == Character.getNumericValue(cpf.charAt(10));
        } catch (Exception e) {
            return false;
        }
    }
}

