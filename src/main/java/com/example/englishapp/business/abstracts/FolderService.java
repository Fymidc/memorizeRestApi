package com.example.englishapp.business.abstracts;

import java.util.List;

import com.example.englishapp.dtos.FolderCreateRequest;
import com.example.englishapp.dtos.FolderResponse;
import com.example.englishapp.dtos.FolderUpdateRequest;
import com.example.englishapp.entities.Folders;

public interface FolderService {
	
	Folders createOneFolder(FolderCreateRequest request);
	void deleteOneFolderById(Long folderid);
	List<FolderResponse> getAllFoldersByUserId(Long userid);
	List<FolderResponse> getAllFoldersByFolderName(String foldername);
	Folders updateFolderByFolderId(Long folderid,FolderUpdateRequest request);
	

}
