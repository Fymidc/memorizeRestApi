package com.example.englishapp.business.abstracts;

import java.util.List;

import com.example.englishapp.dtos.CardCreateRequest;
import com.example.englishapp.dtos.CardUpdateRequest;
import com.example.englishapp.entities.Card;

public interface CardService {

	Card createOneSet(CardCreateRequest request);
	void deleteOnecardById(Long cardid);
	List<Card> getAllCardsBySetId(Long setid);
	Card updateCardByCardId(Long cardid,CardUpdateRequest request);
	Card getOneCardById(Long cardid);
	
}
