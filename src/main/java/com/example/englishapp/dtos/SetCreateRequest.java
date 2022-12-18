package com.example.englishapp.dtos;

import com.example.englishapp.entities.Set;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SetCreateRequest {

	private Long id;
	private Long userid;
	private String avatar;
	private String title;
	private Long folderid;
	
	public SetCreateRequest (Set entity) {
		this.id=entity.getId();
		this.userid=entity.getUser().getId();
		this.avatar= entity.getUser().getAvatar();
		this.title=entity.getTitle();
		this.folderid=entity.getFolders().getId();
	}
	
}
