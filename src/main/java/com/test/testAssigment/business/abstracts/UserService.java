package com.test.testAssigment.business.abstracts;

import java.util.List;

import com.test.testAssigment.business.concretes.userManagerMethods.UserSearch;
import com.test.testAssigment.business.requests.CreateUserRequest;
import com.test.testAssigment.business.requests.UpdateUserRequest;
import com.test.testAssigment.business.responses.GetAllUsersResponse;

public interface UserService {
	List<GetAllUsersResponse> getUsers();
	void add(CreateUserRequest createUserRequest);
	void update(UpdateUserRequest updateUserRequest);
	void delete(int id);

}
