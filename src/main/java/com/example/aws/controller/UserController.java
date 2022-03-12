package com.example.aws.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.aws.entity.User;
import com.example.aws.exception.ResourceNotFoundException;
import com.example.aws.repository.UserRepository;

@RestController	
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserRepository userRepo;
	
	//get all users
	@GetMapping
	public List<User> getAllUsers(){
		return this.userRepo.findAll();
	}
	
	//get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		return this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id "+ userId));
	}
	
	//create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return this.userRepo.save(user);
	}
	
	//update user
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		User existingUser =  this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id "+ userId));
		
		existingUser.setFirstName(user.getFirstName());
		existingUser.setLastName(user.getLastName());
		existingUser.setEmail(user.getEmail());
		
		return this.userRepo.save(existingUser);
	}
	
	//delete user by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		User existingUser =  this.userRepo.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User Not found with id "+ userId));
		
		this.userRepo.delete(existingUser);
		
		return ResponseEntity.ok().build();
	}

}
