package com.example.englishapp.dtos;

import com.example.englishapp.entities.Folders;

import lombok.Data;

@Data
public class FolderUpdateRequest {
	private String title;
	
	public FolderUpdateRequest(Folders entity) {
		this.title = entity.getTitle();
	}
}
