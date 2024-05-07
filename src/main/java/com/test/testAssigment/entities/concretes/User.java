package com.test.testAssigment.entities.concretes;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private int id;

	@NotEmpty(message = "Email cannot be empty")
	@Column(name = "email")
	@Email(message = "Email is not valid")
	private String email;

	@Column(name = "first_name")
	@NotEmpty(message = "First name cannot be empty")
	private String firstName;

	@Column(name = "last_name")
	@NotEmpty(message = "Last name cannot be empty")
	private String lastName;

	@Column(name = "birth_date")
	@NotEmpty(message = "Birth date cannot be empty")
	private LocalDate birthDate;
	
	public void setBirthDate( LocalDate birthDate) {
		if (birthDate.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Birth date cannot be in the future.");
        }
        this.birthDate = birthDate;
        
	}

	@Column(name = "adress")
	private String adress;

	@Column(name = "phone_number")
	private String phoneNumber;

}
