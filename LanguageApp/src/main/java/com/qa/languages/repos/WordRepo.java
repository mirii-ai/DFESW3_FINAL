package com.qa.languages.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.languages.domain.WordConstruct;

@Repository
public interface WordRepo extends JpaRepository<WordConstruct, Integer> {

//	@Query("SELECT lt from LanguageTable lt WHERE lt.category=?1") // passing one parameter
	public List<WordConstruct> getWordBywordCategory(String category);

}
