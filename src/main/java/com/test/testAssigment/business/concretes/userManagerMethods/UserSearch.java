package com.test.testAssigment.business.concretes.userManagerMethods;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.testAssigment.entities.concretes.User;

@Service
public class UserSearch {
	private List<User> users;
	
	public UserSearch() {
		users = new ArrayList<>();
		
	}
	
	public List<User> searchUsersByBirthDateRange() {
//        if (fromDate.isAfter(toDate)) {
//            // Swap the dates if 'fromDate' is after 'toDate'
//            LocalDate temp = fromDate;
//            fromDate = toDate;
//            toDate = temp;
//        }
        
        LocalDate fromDate = LocalDate.of(1, 1, 1);
		LocalDate toDate = LocalDate.now().minusYears(18);

        
        List<User> result = new ArrayList<>();
        for (User user : users) {
            LocalDate userBirthDate = user.getBirthDate();
            if (!userBirthDate.isBefore(fromDate) && !userBirthDate.isAfter(toDate)) {
                result.add(user);
            }
        }
		return result;
        
	}
	
}
