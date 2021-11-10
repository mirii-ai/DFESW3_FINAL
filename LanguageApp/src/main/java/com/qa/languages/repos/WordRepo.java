package com.qa.languages.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.qa.languages.domain.WordConstruct;

@Repository
public interface WordRepo extends JpaRepository<WordConstruct, Integer> {

//	@Query("SELECT lt from LanguageTable lt WHERE lt.category=?1") // passing one parameter
	public List<WordConstruct> getWordBywordCategory(String category);

	public List<WordConstruct> getWordBywordType(String type);

	@Query("SELECT lt from LanguageTable lt WHERE lt.priorityWord=?1")
	public List<WordConstruct> getWordBypriorityWord(boolean inputted);

	@Query("SELECT lt from LanguageTable lt WHERE lt.memorisedWord=?1")
	public List<WordConstruct> getWordBymemorisedWord(boolean inputted);

	@Query("SELECT lt from LanguageTable lt WHERE lt.wordCategory=?1 and lt.wordType=?2") // passing two parameters
	public List<WordConstruct> getWordBywordCategorywordType(String category, String type);

}
