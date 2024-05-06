package com.test.testAssigment.business.responses;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class GetAllUsersResponse {
	private int id;
	private String email;
	private String firstName;
	private String lastName;
	private LocalDate birthDate;
	private String adress;
	private String phoneNumber;
	
}
