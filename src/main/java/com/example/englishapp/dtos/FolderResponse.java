package com.example.englishapp.dtos;

import com.example.englishapp.entities.Folders;

import lombok.Data;

@Data
public class FolderResponse {
	private Long id;
	private String title;
	private Long userid;
	private String username;
	
	public FolderResponse(Folders entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.userid = entity.getUser().getId();
		this.username = entity.getUser().getUserName();
	}
}
