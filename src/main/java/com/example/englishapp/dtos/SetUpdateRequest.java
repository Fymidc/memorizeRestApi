package com.example.englishapp.dtos;

import com.example.englishapp.entities.Set;

import lombok.Data;

@Data
public class SetUpdateRequest {
	private String title;

	public SetUpdateRequest(Set entity) {
		this.title=entity.getTitle();
		
	}
}
