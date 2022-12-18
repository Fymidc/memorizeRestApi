package com.example.englishapp.business.concretes;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.englishapp.business.abstracts.CardService;
import com.example.englishapp.dataaccess.CardDao;
import com.example.englishapp.dataaccess.SetDao;
import com.example.englishapp.dtos.CardCreateRequest;
import com.example.englishapp.dtos.CardUpdateRequest;
import com.example.englishapp.entities.Card;
import com.example.englishapp.entities.Set;

@Service
public class CardManager implements CardService{
	
	private final CardDao cardDao;
	private final SetDao setDao;
	
	public CardManager (CardDao cardDao,SetDao setDao) {
		this.cardDao = cardDao;
		this.setDao = setDao;
	}

	@Override
	public Card createOneSet(CardCreateRequest request) {
		Optional<Set> set = setDao.findById(request.getSetid()); 
		
		if(set.isPresent()) {
			Card newcard = new Card();
		newcard.setId(request.getId());
		newcard.setDefinition(request.getDefinition());
		newcard.setTerm(request.getTerm());
		newcard.setSet(set.get());
		
		return cardDao.save(newcard);
		}
		
		return null;
	}

	@Override
	public void deleteOnecardById(Long cardid) {
		cardDao.deleteById(cardid);
		
	}

	@Override
	public List<Card> getAllCardsBySetId(Long setid) {
		// TODO Auto-generated method stub
		Optional<Set> set = setDao.findById(setid);
		
		List<Card> list;
		
		if(set.isPresent()) {
			list = cardDao.findAllCardBySetId(setid);
		}else {
			return null;
		}
		
		return list;
		
	}

	@Override
	public Card updateCardByCardId(Long cardid,CardUpdateRequest request) {
		Optional<Card> card = cardDao.findById(cardid);
		
		if(card.isPresent()) {
			Card newCard = card.get();
			
			newCard.setTerm(request.getTerm());
			newCard.setDefinition(request.getDefinition());
			
			return cardDao.save(newCard);
		}
		
		return null;
	}

	@Override
	public Card getOneCardById(Long cardid) {

		Optional<Card> card = cardDao.findById(cardid);
		if(card.isPresent()) {
			return card.get();
		}
		
		return null;
	}

}
