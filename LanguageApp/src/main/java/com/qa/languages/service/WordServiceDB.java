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

	// Enables the user to set the boolean MemorisedWord to true (or whatever the
	// user changes it to)
	@Override
	public WordConstruct updateMemoriseWord(Integer word_id, WordConstruct w) {
		WordConstruct toUpdate = this.returnWordID(word_id);
		toUpdate.setMemorisedWord(w.isMemorisedWord());
		return this.repo.save(toUpdate);
	}

}
