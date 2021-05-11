package com.nagarro.Login.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import com.nagarro.Login.model.User;

/**
 * User details service for login
 * 
 * @author surbhiagarwal
 *
 */
@Service
public class MyUserDetailsService implements UserDetailsService {
	
	List<User> registeredUsers = Arrays.asList(new User
			("surbhiagarwal219@gmail.com","abcd","1234567890","Surbhi Agarwal","Ghaziabad", null));
	
	public UserDetails loadUserByUsername(String email) {
		UserDetails userDetails = null;
		for(User user : getAllUsers()) {
			if(user.getEmail().equals(email)) {
				userDetails = new org.springframework.security.core.userdetails.User(user.getEmail(),user.getPassword(),new ArrayList<>());
			}
		}
		return userDetails;
	}
	
	public List<User> getAllUsers(){
		
		return registeredUsers;
	}
	
	
}
