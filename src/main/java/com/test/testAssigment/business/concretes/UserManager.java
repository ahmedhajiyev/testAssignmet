package com.test.testAssigment.business.concretes;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.test.testAssigment.business.abstracts.UserService;
import com.test.testAssigment.business.concretes.userManagerMethods.Age;
import com.test.testAssigment.business.concretes.userManagerMethods.UserSearch;
import com.test.testAssigment.business.requests.CreateUserRequest;
import com.test.testAssigment.business.requests.UpdateUserRequest;
import com.test.testAssigment.business.responses.GetAllUsersResponse;
import com.test.testAssigment.core.utilities.mappers.ModelMapperService;
import com.test.testAssigment.core.utilities.mappers.exceptions.AgeLessThanEighteenException;
import com.test.testAssigment.dataAccess.abstracts.UserRepository;
import com.test.testAssigment.entities.concretes.User;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Service
public class UserManager implements UserService {

	private UserRepository userRepository;
	private ModelMapperService modelMapperService;
	private UserSearch userSearch;
	private Age age;

	@Override
	public List<GetAllUsersResponse> getUsers() {
		
		
		List<User> users = userSearch.searchUsersByBirthDateRange();
		List<GetAllUsersResponse> result = users.stream()
				.map(user -> this.modelMapperService.forResponse().map(user, GetAllUsersResponse.class))
				.collect(Collectors.toList());
		return result;
	}
	
	@Override
	public void add(CreateUserRequest createUserRequest) {
		LocalDate today = LocalDate.now();

		User user = this.modelMapperService.forRequest().map(createUserRequest, User.class);

		long yearsDiff = ChronoUnit.YEARS.between(today, user.getBirthDate());
		try {
//			validateAge(yearsDiff);
			age.validateAge(yearsDiff);
		} catch (AgeLessThanEighteenException e) {
			e.printStackTrace();
		}
		this.userRepository.save(user);
	}

	@Override
	public void update(UpdateUserRequest updateUserRequest) {
		LocalDate today = LocalDate.now();
		User user = this.modelMapperService.forRequest().map(updateUserRequest, User.class);
		
		long yearsDiff = ChronoUnit.YEARS.between(today, user.getBirthDate());
		try {
			age.validateAge(yearsDiff);
		} catch (AgeLessThanEighteenException e) {
			e.printStackTrace();
		}
		
		this.userRepository.save(user);

	}

	@Override
	public void delete(int id) {
		this.userRepository.deleteById(id);

	}

	



}
