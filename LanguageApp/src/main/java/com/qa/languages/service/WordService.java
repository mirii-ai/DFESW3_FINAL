package com.qa.languages.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.languages.domain.WordConstruct;

public class WordService {

	private WordRepo repo;
	private List<WordConstruct> wordList = new ArrayList<>();

	@Autowired // change later once added the Service class
	public WordService(WordRepo repo) {
		super();
		this.repo = repo;
	}

	public WordConstruct addNewWord(WordConstruct newWord) {
		this.wordList.add(newWord);
		return this.wordList.get(this.wordList.size() - 1);
	}

	public boolean updateMemoriseWord(@PathVariable Integer word_id) {
		WordConstruct toChange = this.wordList.get(word_id);
		toChange.setMemorisedWord(true);
		if (toChange.isMemorisedWord() == true) {
			System.out.println("Word has been memorised.");
			return true;
		} else {
			System.out.println("Word has not yet been memorised.");
			return false;
		}
	}
}
