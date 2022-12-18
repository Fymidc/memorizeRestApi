package com.example.englishapp.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.englishapp.entities.Card;


public interface CardDao extends JpaRepository<Card, Long> {

	List<Card> findAllCardBySetId(Long setid);

}
