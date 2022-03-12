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
import com.example.aws.service.UserService;

@RestController	
@RequestMapping("/api")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	//get all users
	@GetMapping
	public List<User> getAllUsers(){
		return userService.getAllUsers();
	}
	
	//get user by id
	@GetMapping("/{id}")
	public User getUserById(@PathVariable (value = "id") long userId) {
		return userService.getUserById(userId);
	}
	
	//create user
	@PostMapping
	public User createUser(@RequestBody User user) {
		return userService.createUser(user);
	}
	
	//update user
	@PutMapping("/{id}")
	public User updateUser(@RequestBody User user, @PathVariable ("id") long userId) {
		
		return userService.updateUser(user, userId);
	}
	
	//delete user by Id
	@DeleteMapping("/{id}")
	public ResponseEntity<User> deleteUser(@PathVariable ("id") long userId){
		
		return userService.deleteUser(userId);
	}

}
