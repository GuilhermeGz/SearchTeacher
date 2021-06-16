package br.edu.ufape.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CPFValidator implements ConstraintValidator<CPFValid, String> {


	@Override
	public boolean isValid(String input, ConstraintValidatorContext cxt) {
		return true;
	}

}
