package com.test.testAssigment.business.requests;

import java.util.Date;

import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UpdateUserRequest {
	
	@NotNull(message = "ID may not be empty")
	private int id;
	
	private String email;
	private String firstName;
	private String lastName;
	private Date birthDate;
	private String adress;
	private String phoneNumber;
	
	

}
