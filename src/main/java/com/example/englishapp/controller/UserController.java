package com.example.englishapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.englishapp.business.abstracts.UserService;
import com.example.englishapp.dtos.UserUpdateRequest;
import com.example.englishapp.entities.User;

@RestController
@RequestMapping("/user")
public class UserController {
	
	private final UserService userService;
	
	public UserController( UserService userService) {
		this.userService = userService;
	}
	
	//create and login will be with email and googleauth
	@PostMapping
	public User createOneUser(@RequestBody User request) {
		return userService.createOneUser(request);
	}
	
	@GetMapping
	public List<User> getAllusers(){
		return userService.getAllusers();
	}

	@GetMapping("/{id}")
	public User getOneUserById(@PathVariable Long id) {
		return userService.getOneUserById(id);
	}
	
	@DeleteMapping("/{id}")
	public void deleteOneUser(Long id) {
		userService.deleteOneUser(id);
	}
	
	@GetMapping("/name")
	public User getOneUserByUserName(@RequestParam String username) {
		return userService.getOneUserByUserName(username);
	}
	
	@PutMapping("/{id}")
	public User updateOneUser(Long id,UserUpdateRequest newUser) {
		return userService.updateOneUser(id, newUser);
	}

	@PostMapping("/favorite")//check thismethod
	public User addFavorites(@RequestParam Long userid, @RequestParam Long cardid) {
		return userService.addFavorites(userid, cardid);
	}
}
