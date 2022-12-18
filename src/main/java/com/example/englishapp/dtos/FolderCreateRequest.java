package com.example.englishapp.dtos;

import com.example.englishapp.entities.Folders;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class FolderCreateRequest {
	private Long id;
	private String title;
	private Long userid;
	
	public FolderCreateRequest(Folders entity) {
		this.id = entity.getId();
		this.title = entity.getTitle();
		this.userid = entity.getUser().getId();
	}
}
