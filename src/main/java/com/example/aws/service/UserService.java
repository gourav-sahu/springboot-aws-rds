package com.example.aws.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.example.aws.entity.User;
import com.example.aws.exception.ResourceNotFoundException;
import com.example.aws.repository.UserRepository;

public class UserService {
	
	@Autowired
	private UserRepository userRepo;

	public List<User> getAllUsers() {
		return userRepo.findAll();
	}

	public User getUserById(long userId) {
		return userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found by Id: "+ userId));	
	}

	public User createUser(User user) {
		return userRepo.save(user);
	}

	public User updateUser(User user, long userId) {
		User existingUser = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found by Id: "+ userId));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setEmail(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		return userRepo.save(existingUser);
	}

	public ResponseEntity<User> deleteUser(long userId) {
		User existingUser = userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not Found by Id: "+ userId));
		
		userRepo.delete(existingUser);
		return ResponseEntity.ok().build();
	}

}
