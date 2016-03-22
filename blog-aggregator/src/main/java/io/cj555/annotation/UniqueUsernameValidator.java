package io.cj555.annotation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import io.cj555.repository.UserRepository;

public class UniqueUsernameValidator implements ConstraintValidator<UniqueUsername, String> {

	@Autowired
	private UserRepository UserRepository;

	@Override
	public void initialize(UniqueUsername arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean isValid(String userName, ConstraintValidatorContext arg1) {

		if (UserRepository == null) {
			return true;
		}

		return UserRepository.findByName(userName) == null;
	}

}
