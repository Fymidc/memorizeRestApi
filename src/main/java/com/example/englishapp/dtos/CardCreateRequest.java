package com.example.englishapp.dtos;

import com.example.englishapp.entities.Card;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CardCreateRequest {
	private Long id;
	private String definition;
	private String term;
	private Long setid;
	
	public CardCreateRequest(Card entity) {
		this.id=entity.getId();
		this.definition=entity.getDefinition();
		this.term=entity.getTerm();
		this.setid=entity.getSet().getId();
	}

}
