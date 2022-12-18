package com.example.englishapp.dtos;

import com.example.englishapp.entities.User;

import lombok.Data;

@Data
public class UserUpdateRequest {
	private String userName;
	private String email;
	private String avatar;
	private String schoolName;
	
	public UserUpdateRequest(User entity) {
		this.userName=entity.getUserName();
		this.email=entity.getEmail();
		this.avatar=entity.getAvatar();
		this.schoolName=entity.getSchoolName();
	}
}
