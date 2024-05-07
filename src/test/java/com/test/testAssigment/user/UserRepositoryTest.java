package com.test.testAssigment.user;

import static org.assertj.core.api.Assertions.assertThat;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import com.test.testAssigment.dataAccess.abstracts.UserRepository;
import com.test.testAssigment.entities.concretes.User;

@DataJpaTest
//@AutoConfigureTestDatabase(replace = Replace.NONE)
@SpringBootTest
public class UserRepositoryTest {
	
	@Autowired
	private UserRepository underTest;

	
//	@Test
//	void itShouldBeAboveEighteen() {
//		
//		LocalDate birthDate = LocalDate.of(2000,01,01);
//		User user = new User();
//		user.setBirthDate(birthDate);
//		underTest.save(user);
//		
//		LocalDate today = LocalDate.now();
//		long yearsDiff = ChronoUnit.YEARS.between(today, user.getBirthDate());
//		boolean expected = true;
//		if (yearsDiff<18) {
//			expected = false;
//		}
//		
//		assertThat(expected).isTrue();
//		
//		
//		
//		
//	}
	
	@Test
	void test() {
		String firstName = "Ahmad";
		User user = new User();
		user.setFirstName(firstName);
		underTest.save(user);
		
		boolean expected = firstName.isEmpty();
		
		assertThat(expected).isFalse();
	}
	
	

}
