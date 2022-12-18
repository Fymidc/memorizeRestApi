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

import com.example.englishapp.business.abstracts.SetService;
import com.example.englishapp.dtos.SetCreateRequest;
import com.example.englishapp.dtos.SetResponse;
import com.example.englishapp.dtos.SetUpdateRequest;
import com.example.englishapp.entities.Set;

@RestController
@RequestMapping("/set")
public class SetController {
	
	private final SetService setService;
	
	public SetController(SetService setService) {
		this.setService = setService;
	}
	
	@PostMapping
	public Set createOneSet (@RequestBody SetCreateRequest request) {
		return setService.createOneSet(request);
	}
	
	@DeleteMapping("{id}")
	public void deleteOneSetById(@PathVariable Long id) {
		setService.deleteOneSetById(id);
	}

	@GetMapping("{id}")
	public List<SetResponse> getAllSetsByUserId(@PathVariable Long id){
		return setService.getAllSetsByUserId(id);
	}
	
	@GetMapping
	public List<SetResponse> getAllSetsBySetName(@RequestParam String setname){
		return setService.getAllSetsBySetName(setname);
	}
	
	@GetMapping("/folder")
	public List<SetResponse> getAllSetsByFoldersId(@RequestParam Long folderid){
		return setService.getAllSetsByFoldersId(folderid);
	}
	
	@PutMapping("{id}")
	public Set updateSetBySetId(@PathVariable Long id, @RequestBody SetUpdateRequest request) {
		return setService.updateSetBySetId(id, request);
	}
}
