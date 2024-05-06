package com.test.testAssigment.webApi.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.test.testAssigment.business.abstracts.UserService;
import com.test.testAssigment.business.requests.CreateUserRequest;
import com.test.testAssigment.business.requests.UpdateUserRequest;
import com.test.testAssigment.business.responses.GetAllUsersResponse;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {
	private UserService userService;
	
	@GetMapping
	public List<GetAllUsersResponse> getAll(){
		return userService.getUsers();
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public void add(@RequestBody CreateUserRequest createUserRequest) {
		this.userService.add(createUserRequest);
	}
	
	@PutMapping
	public void update(@RequestBody UpdateUserRequest updateUserRequest) {
		this.userService.update(updateUserRequest);
	}
	
	@DeleteMapping("/{id}")
	public void delete(int id) {
		this.userService.delete(id);
	}

}
