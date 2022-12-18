package com.example.englishapp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.englishapp.business.abstracts.SetService;
import com.example.englishapp.dataaccess.CardDao;
import com.example.englishapp.dataaccess.FolderDao;
import com.example.englishapp.dataaccess.SetDao;
import com.example.englishapp.dataaccess.UserDao;
import com.example.englishapp.dtos.SetCreateRequest;
import com.example.englishapp.dtos.SetResponse;
import com.example.englishapp.dtos.SetUpdateRequest;
import com.example.englishapp.entities.Folders;
import com.example.englishapp.entities.Set;
import com.example.englishapp.entities.User;

@Service
public class SetManager implements SetService {
	
	private final SetDao setDao;
	private final FolderDao folderDao;
	private final UserDao userDao;
	private final CardDao cardDao;
	
	public SetManager(SetDao setDao,FolderDao folderDao,UserDao userDao,CardDao cardDao) {
		this.setDao=setDao;
		this.folderDao=folderDao;
		this.userDao=userDao;
		this.cardDao = cardDao;
	}
	

	@Override
	public Set createOneSet(SetCreateRequest request) {
		
		Optional<User> user = userDao.findById(request.getUserid());
		Optional<Folders> folder = folderDao.findById(request.getFolderid());
		
		if(folder.isPresent() && user.isPresent() ) {
			Set set = new Set();
			
		set.setId(request.getId());
		set.setTitle(request.getTitle());
		set.setFolders(folder.get());
		set.setUser(user.get());
		
		return setDao.save(set);
		}
		
		
		return null;
	}

	
	@Override
	public List<SetResponse> getAllSetsByFoldersId(Long folderid) {
		Optional<Folders> folder = folderDao.findById(folderid);
		
		List<Set> list;
		if(folder.isPresent()) {
			list = setDao.findByFoldersId(folderid);
			
			return list.stream().map(e-> new SetResponse(e,cardDao)).collect(Collectors.toList());
		}
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public void deleteOneSetById(Long setid) {
		setDao.deleteById(setid);
		
	}

	@Override
	public List<SetResponse> getAllSetsByUserId(Long userid) {
		Optional<User> user = userDao.findById(userid);
		
		List<Set> list;
		
		if(user.isPresent()) {
			list = setDao.findAllSetByUserId(userid);
		}else {
			return null;
		}
		// TODO Auto-generated method stub
		return list.stream().map(e-> new SetResponse(e,cardDao)).collect(Collectors.toList());
	}

	@Override
	public List<SetResponse> getAllSetsBySetName(String setname) {
		
		List<Set> list;
		
	
		list = setDao.findByTitle(setname);
		
		return list.stream().map(e-> new SetResponse(e,cardDao)).collect(Collectors.toList());
	}

	@Override
	public Set updateSetBySetId(Long setid,SetUpdateRequest request) {
		Optional<Set> foundedset = setDao.findById(setid);
		
		if(foundedset.isPresent()) {
			Set set = foundedset.get();
			set.setTitle(request.getTitle());
			
			return setDao.save(set);
		}
		return null;
	}


	

}
