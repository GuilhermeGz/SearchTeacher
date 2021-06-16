package br.edu.ufape.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class EmailValidator implements 
  ConstraintValidator<MeuEmail, String> {

    @Override
    public void initialize(MeuEmail mail) {
    }

    @Override
    public boolean isValid(String input,
      ConstraintValidatorContext cxt) {
        return input != null && input.matches("^[a-zA-Z0-9_-]+@[a-zA-Z0-9]+(?:\\.[a-zA-Z0-9-]+)$")
          && (input.length() <= 40);
    }

}
