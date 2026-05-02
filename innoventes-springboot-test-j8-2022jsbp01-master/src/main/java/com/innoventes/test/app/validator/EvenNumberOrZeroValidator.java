package com.innoventes.test.app.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.innoventes.test.app.annotation.EvenNumberOrZero;

public class EvenNumberOrZeroValidator implements ConstraintValidator<EvenNumberOrZero,Integer> 
{
	@Override
	public boolean isValid(Integer value,ConstraintValidatorContext context)
	{
		if(value == null)
		{
			return true;
			
		}
		return value % 2 == 0;
	}
}
