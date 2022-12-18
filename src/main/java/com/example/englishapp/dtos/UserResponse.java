package com.example.englishapp.dtos;

import com.example.englishapp.entities.Folders;
import com.example.englishapp.entities.Set;

import lombok.Data;

@Data
public class UserResponse {
	private Long id;
	private String userName;
	private String avatar;
	private Folders folder;
	private Set set;
	private String favorites;
}
