package com.example.englishapp.dtos;

import com.example.englishapp.dataaccess.CardDao;

import com.example.englishapp.entities.Set;

import lombok.Data;

@Data
public class SetResponse {
	private Long id;
	private Long userid;
	private String title;
	private Long termAmount;
	private String userName;
	private Long folderid;
	
	public SetResponse(Set entity,CardDao cardDao) {
		this.id=entity.getId();
		this.userid=entity.getUser().getId();
		this.title=entity.getTitle();
		this.termAmount = (long) cardDao.findAllCardBySetId(id).size(); //fix this
		this.userName = entity.getUser().getUserName();
		this.folderid = entity.getFolders().getId();
	}
}
