package com.qa.languages.service;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import com.qa.languages.domain.WordConstruct;
import com.qa.languages.repos.WordRepo;

public class WordServiceDB extends WordService {

	private WordRepo repo;

	public WordServiceDB(WordRepo repo) {
		super();
		this.repo = repo;
	}

	public WordConstruct returnWordID(Integer word_id) {
		Optional<WordConstruct> optionalWord = this.repo.findById(word_id);
		if (optionalWord.isPresent()) {
			WordConstruct returnedWord = optionalWord.get();
			return returnedWord;
		} else {
			throw new EntityNotFoundException("No word with this ID has been found in the database.");
		}
	}

//	public WordConstruct returnWord(String word) {
//		Optional<WordConstruct> optionalWord = this.repo.Optional.ofNullable(word);
//		if (optionalWord.isPresent()) {
//			WordConstruct returnedWord = optionalWord.get();
//			return returnedWord;
//		} else {
//			throw new EntityNotFoundException("No word matching your query has been found.");
//		}
//	}

	// Enables the user to set the boolean MemorisedWord to true (or whatever the
	// user changes it to)
	@Override
	public WordConstruct updateMemoriseWord(Integer word_id, WordConstruct w) {
		WordConstruct toUpdate = this.returnWordID(word_id);
		toUpdate.setMemorisedWord(w.isMemorisedWord());
		return this.repo.save(toUpdate);
	}

	@Override
	public WordConstruct updatePriority(Integer word_id, WordConstruct www) {
		WordConstruct toPrioritise = this.returnWordID(word_id);
		toPrioritise.setPriorityWord(www.isPriorityWord());
		return this.repo.save(toPrioritise);
	}

	@Override
	public boolean deleteWord(Integer word_id) {
		this.repo.deleteById(word_id);
		return !this.repo.existsById(word_id);
	}

}
