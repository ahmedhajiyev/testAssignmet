package com.test.testAssigment.business.concretes.userManagerMethods;

import org.springframework.stereotype.Service;

import com.test.testAssigment.core.utilities.mappers.exceptions.AgeLessThanEighteenException;

@Service
public class Age {

	 public static void validateAge(long age) throws AgeLessThanEighteenException {
		if (age < 18) {
			throw new AgeLessThanEighteenException();
		}

	}
}
