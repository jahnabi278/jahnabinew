package com.example.demo;

import org.springframework.stereotype.Service;

@Service
public class UserService {

	public void saveUser(User user) {
		System.out.println(user);
	}
}
