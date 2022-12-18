package com.example.englishapp.business.concretes;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.example.englishapp.business.abstracts.FolderService;
import com.example.englishapp.dataaccess.FolderDao;
import com.example.englishapp.dataaccess.UserDao;
import com.example.englishapp.dtos.FolderCreateRequest;
import com.example.englishapp.dtos.FolderResponse;
import com.example.englishapp.dtos.FolderUpdateRequest;
import com.example.englishapp.entities.Folders;
import com.example.englishapp.entities.User;

@Service
public class FolderManager implements FolderService {

	private final FolderDao folderDao;
	private final UserDao userDao;
	
	
	public FolderManager(FolderDao folderDao,UserDao userDao) {
		this.folderDao = folderDao;
		this.userDao = userDao;
	}
	
	@Override
	public Folders createOneFolder(FolderCreateRequest request) {
		
		Optional<User> user = userDao.findById(request.getUserid());
		
		if(user.isPresent()) {
			Folders folder = new Folders();
		folder.setId(request.getId());
		folder.setTitle(request.getTitle());
		folder.setUser(user.get());
		
		return folderDao.save(folder);
		}
		
		
		return null;
	}

	@Override
	public void deleteOneFolderById(Long folderid) {
		folderDao.deleteById(folderid);
		
	}

	@Override
	public List<FolderResponse> getAllFoldersByUserId(Long userid) {
		Optional<User> user = userDao.findById(userid);
		
		List<Folders> list;
		
		if(user.isPresent()) {
			list = folderDao.findByUserId(userid);
			
			return list.stream().map(e-> new FolderResponse(e)).collect(Collectors.toList());
		}

		return null;
	}

	@Override
	public List<FolderResponse> getAllFoldersByFolderName(String foldername) {
		List<Folders> foundedFolder = folderDao.findByTitle(foldername);
		
		return foundedFolder.stream().map(e-> new FolderResponse(e)).collect(Collectors.toList());
	}

	@Override
	public Folders updateFolderByFolderId(Long folderid,FolderUpdateRequest request) {
		
		Optional<Folders> foundedfolder = folderDao.findById(folderid);
		
		if(foundedfolder.isPresent()) {
			Folders newfolder = foundedfolder.get();
			newfolder.setTitle(request.getTitle());
			
			return folderDao.save(newfolder);
		}
		
		return null;
	}

}
