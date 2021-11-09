package com.qa.languages.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.qa.languages.domain.WordConstruct;

public class WordService {

	private List<WordConstruct> wordList = new ArrayList<>();

	public WordConstruct addNewWord(WordConstruct newWord) {
		this.wordList.add(newWord);
		return this.wordList.get(this.wordList.size() - 1); // returns the newly added word
	}

	public WordConstruct updateMemoriseWord(@PathVariable Integer word_id, @RequestBody WordConstruct w) {
		return this.wordList.set(word_id, w);
	}

//	public boolean updateMemoriseWord(@PathVariable Integer word_id, @RequestBody WordConstruct w) {
//		WordConstruct toChange = this.wordList.get(word_id);
//		toChange.setMemorisedWord(true);
//		if (w.isMemorisedWord() == true) {
//			System.out.println("Word has been memorised.");
//			return true;
//		} else {
//			System.out.println("Word has not yet been memorised.");
//			return false;
//		}

	public WordConstruct searchforWordWithID(@PathVariable Integer wordId) {
		return this.wordList.get(wordId);
	}

	public WordConstruct searchForWord(@PathVariable String wordSearch) {
		int indexOfWord = wordList.indexOf(wordSearch);
		return this.wordList.get(indexOfWord);
	}
}
