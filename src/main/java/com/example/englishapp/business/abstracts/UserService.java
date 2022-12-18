package com.example.englishapp.business.abstracts;

import java.util.List;

import com.example.englishapp.dtos.UserUpdateRequest;
import com.example.englishapp.entities.User;

public interface UserService {

	//User createoneUser();//will be handle with email or google auth
	User createOneUser(User request);//temporary method for testing
	
	List<User> getAllusers();
	
	User getOneUserById(Long userid);
	void deleteOneUser(Long userid);
	User getOneUserByUserName(String username);
	User updateOneUser(Long userid,UserUpdateRequest newUser);
	User addFavorites(Long userid,Long cardid);
	
}
