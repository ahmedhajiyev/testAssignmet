package com.test.testAssigment.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import com.test.testAssigment.entities.concretes.User;

public interface UserRepository extends JpaRepository<User, Integer> {

}
