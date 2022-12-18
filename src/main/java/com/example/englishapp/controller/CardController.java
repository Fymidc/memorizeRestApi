package com.example.englishapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.englishapp.business.abstracts.CardService;
import com.example.englishapp.dtos.CardCreateRequest;
import com.example.englishapp.dtos.CardUpdateRequest;
import com.example.englishapp.entities.Card;

@RestController
@RequestMapping("/card")
public class CardController {
	
	private final CardService cardService;
	
	public CardController(CardService cardService) {
		this.cardService = cardService;
	}

	@PostMapping
	public Card createOneSet(@RequestBody CardCreateRequest request) {
		return cardService.createOneSet(request);
		
	}
	
	@DeleteMapping("{id}")
	public void deleteOnecardById(@PathVariable Long id) {
		cardService.deleteOnecardById(id);
	}
	
	@GetMapping("/set/{id}")
	public List<Card> getAllCardsBySetId(@PathVariable Long id){
		return cardService.getAllCardsBySetId(id);
	}

	@PutMapping("{id}")
	public Card updateCardByCardId(@PathVariable Long id,@RequestBody CardUpdateRequest request) {
		return cardService.updateCardByCardId(id, request);
	}
	
	
	@GetMapping("{id}")
	public Card getOneCardById(@PathVariable Long id) {
		return cardService.getOneCardById(id);
	}
	
	
}
