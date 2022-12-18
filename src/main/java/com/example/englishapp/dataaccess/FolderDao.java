package com.example.englishapp.dataaccess;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.englishapp.entities.Folders;

public interface FolderDao extends JpaRepository<Folders, Long>{

	List<Folders> findByUserId(Long userid);

	List<Folders> findByTitle(String foldername);

}
