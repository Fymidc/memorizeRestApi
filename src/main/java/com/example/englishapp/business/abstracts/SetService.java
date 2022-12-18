package com.example.englishapp.business.abstracts;

import java.util.List;

import com.example.englishapp.dtos.SetCreateRequest;
import com.example.englishapp.dtos.SetResponse;
import com.example.englishapp.dtos.SetUpdateRequest;
import com.example.englishapp.entities.Set;

public interface SetService {
	Set createOneSet(SetCreateRequest request);
	void deleteOneSetById(Long setid);
	List<SetResponse> getAllSetsByUserId(Long userid);
	List<SetResponse> getAllSetsByFoldersId(Long folderid);
	List<SetResponse> getAllSetsBySetName(String setname);
	Set updateSetBySetId(Long setid,SetUpdateRequest request);
	

}
