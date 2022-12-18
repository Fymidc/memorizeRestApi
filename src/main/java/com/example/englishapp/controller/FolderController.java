package com.example.englishapp.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.englishapp.business.abstracts.FolderService;
import com.example.englishapp.dtos.FolderCreateRequest;
import com.example.englishapp.dtos.FolderResponse;
import com.example.englishapp.dtos.FolderUpdateRequest;
import com.example.englishapp.entities.Folders;

@RestController
@RequestMapping("/folder")
public class FolderController {
	
	private final FolderService folderService;
	
	public FolderController(FolderService folderService) {
		this.folderService = folderService;
	}
	
	@PostMapping
	public Folders createOneFolder(@RequestBody FolderCreateRequest request) {
		return folderService.createOneFolder(request);
	}
	
	@DeleteMapping("{id}")
	public void deleteOneFolderById(@PathVariable Long id) {
		folderService.deleteOneFolderById(id);
	}
	
	@GetMapping("{id}")
	public List<FolderResponse> getAllFoldersByUserId(@PathVariable Long id){
		return folderService.getAllFoldersByUserId(id);
	}
	
	@GetMapping
	public List<FolderResponse> getAllFoldersByFolderName(@RequestParam String foldername){
		return getAllFoldersByFolderName(foldername);
	}
	
	@PutMapping("{id}")
		public Folders updateFolderByFolderId(Long id,FolderUpdateRequest request) {
			return folderService.updateFolderByFolderId(id, request);
	}
	
	

}
