package com.example.englishapp.business.concretes;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.englishapp.business.abstracts.UserService;
import com.example.englishapp.dataaccess.CardDao;
import com.example.englishapp.dataaccess.UserDao;
import com.example.englishapp.dtos.UserUpdateRequest;
import com.example.englishapp.entities.Card;
import com.example.englishapp.entities.User;

@Service
public class UserManager implements UserService {
	
	private final UserDao userDao;
	private final CardDao cardDao;
	
	public UserManager(UserDao userDao,CardDao cardDao ) {
		this.userDao=userDao;
		this.cardDao = cardDao;
	}

	
	
	@Override
	public User createOneUser(User request) {
		
		User user = new User();
		user.setId(request.getId());
		user.setUserName(request.getUserName());
		user.setEmail(request.getEmail());
		user.setAvatar(request.getAvatar());
		user.setSchoolName(request.getSchoolName());
		user.setCardid(request.getCardid());
		
		return userDao.save(user);
		
	}
	
	@Override
	public List<User> getAllusers() {
		// TODO Auto-generated method stub
		return userDao.findAll();
	}

	@Override
	public User getOneUserById(Long userid) {
		User user = userDao.findById(userid).orElseThrow();
		return user;
	}

	@Override
	public void deleteOneUser(Long userid) {
		userDao.deleteById(userid);
		
	}

	@Override
	public User getOneUserByUserName(String username) {
		User user = userDao.findUserByUserName(username); 
		return user;
	}

	@Override
	public User updateOneUser(Long userid, UserUpdateRequest newUser) {
			
		Optional<User> user = userDao.findById(userid);
		
		if(user.isPresent()) {
			User newuser = user.get();
			newuser.setUserName(newuser.getUserName());
			newuser.setEmail(newUser.getEmail());
			newuser.setAvatar(newUser.getAvatar());
			newuser.setSchoolName(newuser.getSchoolName());
			
			return userDao.save(newuser);
		}
		
		return null;
	}

	@Override 
	public User addFavorites(Long userid, Long cardid) {
		Optional<User> user = userDao.findById(userid);
		Optional<Card> card = cardDao.findById(cardid);
		
		List<Long> cardlist = new ArrayList<>();
		if(user.isPresent() && card.isPresent()) {
			cardlist.add(cardid);
			User foundeduser = user.get();
			foundeduser.setCardid(cardlist);
			
			return userDao.save(foundeduser); 
		}
		// TODO Auto-generated method stub
		return null;
	}

	

}
