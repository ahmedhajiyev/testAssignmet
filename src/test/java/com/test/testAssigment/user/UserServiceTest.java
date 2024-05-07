package com.test.testAssigment.user;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.test.testAssigment.business.concretes.UserManager;
import com.test.testAssigment.business.requests.CreateUserRequest;
import com.test.testAssigment.core.utilities.mappers.exceptions.AgeLessThanEighteenException;
import com.test.testAssigment.dataAccess.abstracts.UserRepository;
import com.test.testAssigment.entities.concretes.User;

@ExtendWith(MockitoExtension.class)
public class UserServiceTest {
	
	@Mock private UserRepository userRepository;
	
	private UserManager underTest;
	
	@BeforeEach
	void setUp() {
		underTest = new UserManager(userRepository,null);
	}
	
	@Test
	void canGetAllMenus() {
		//when
		underTest.getUsers();
		//then
		verify(userRepository).findAll();
		
		
	}
	
	@Test
	void canAddMenu() throws AgeLessThanEighteenException {
		//given
		CreateUserRequest createUserRequest = new CreateUserRequest();
		createUserRequest.setEmail("test@gmail.com");
		createUserRequest.setFirstName("FirstName");
		createUserRequest.setLastName("LastName");
		createUserRequest.setBirthDate(LocalDate.of(2000, 10, 10));
		createUserRequest.setAdress("TestAdress");
		createUserRequest.setPhoneNumber("+123456789");
		//when
		underTest.add(createUserRequest);
		
		//then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		
		verify(userRepository).save(userArgumentCaptor.capture());
		
		User capturedUser = userArgumentCaptor.getValue();
		
		assertEquals(capturedUser, createUserRequest.getFirstName());
	}
	
	@Test
	void canUpdateMenu() {
		//given
		CreateUserRequest updateUserRequest = new CreateUserRequest();
		updateUserRequest.setEmail("test@gmail.com");
		updateUserRequest.setFirstName("FirstName");
		updateUserRequest.setLastName("LastName");
		updateUserRequest.setBirthDate(LocalDate.of(2000, 10, 10));
		updateUserRequest.setAdress("TestAdress");
		updateUserRequest.setPhoneNumber("+123456789");
		//when
		underTest.add(updateUserRequest);
		
		//then
		ArgumentCaptor<User> userArgumentCaptor = ArgumentCaptor.forClass(User.class);
		
		verify(userRepository).save(userArgumentCaptor.capture());
		
		User capturedUser = userArgumentCaptor.getValue();
		
		assertEquals(capturedUser, updateUserRequest.getFirstName());
	}

}
