package com.example.englishapp.dataaccess;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.englishapp.entities.Folders;
import com.example.englishapp.entities.Set;

public interface SetDao extends JpaRepository<Set, Long>{

	List<Set> findAllSetByUserId(Long userid);

	List<Set> findByTitle(String setname);

	List<Set> findByFoldersId(Long folderid);

}
