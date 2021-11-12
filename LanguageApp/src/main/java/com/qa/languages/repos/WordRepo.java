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

	@Query("SELECT lt from LanguageTable lt WHERE lt.priorityWord=?1") // returns by search priority (ie. if 'true' or
																		// 'false')
	public List<WordConstruct> getWordBypriorityWord(boolean inputted);

	@Query("SELECT lt from LanguageTable lt WHERE lt.memorisedWord=?1") // returns by search memorised (ie. if 'true' or
																		// 'false')
	public List<WordConstruct> getWordBymemorisedWord(boolean inputted);

	@Query("SELECT lt from LanguageTable lt WHERE lt.wordCategory=?1 and lt.wordType=?2") // passing two parameters,
																							// returns results based on
																							// category and word type
	public List<WordConstruct> getWordBywordCategorywordType(String category, String type);

	List<ForeignWordEntry> findAllBy(); // returns ForeignWord, WordType, Category only (but returns all)

	// random entries limit keyword - research sql random DOES NOT WORK BUT I TRIED
//	@Query(value = "SELECT lt FROM LanguageTable lt LIMIT", nativeQuery = true)
//	List<LimitReturn> findAllByLimit();
}
