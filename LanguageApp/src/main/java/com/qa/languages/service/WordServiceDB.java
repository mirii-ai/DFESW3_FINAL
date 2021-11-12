package com.qa.languages.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.qa.languages.domain.WordConstruct;
import com.qa.languages.repos.ForeignWordEntry;
import com.qa.languages.repos.WordRepo;

@Service
public class WordServiceDB {

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

	public WordConstruct addNewWord(WordConstruct newWord) {
		return this.repo.save(newWord);
	}

	public List<WordConstruct> getForeignWord(String foreignWord) {
		return this.repo.getWordByforeignWord(foreignWord);
	}

	public WordConstruct searchforWordWithID(@PathVariable Integer wordId) {

		return this.repo.findById(wordId).get();
	}

	// Enables the user to set the boolean MemorisedWord to true (or whatever the
	// user changes it to)
	public WordConstruct updateMemoriseWord(Integer word_id, WordConstruct w) {
		WordConstruct toUpdate = this.returnWordID(word_id);
		toUpdate.setMemorisedWord(w.isMemorisedWord());
		return this.repo.save(toUpdate);
	}

	public List<WordConstruct> getWords() {
		return this.repo.findAll();
	}

	public List<WordConstruct> getWordsbyCategory(String category) {
		return this.repo.getWordBywordCategory(category);
	}

	public List<WordConstruct> getWordsbyType(String type) {
		return this.repo.getWordBywordType(type);
	}

	public List<WordConstruct> getWordsbyCategoryType(String category, String type) {
		return this.repo.getWordBywordCategorywordType(category, type);
	}

	public List<WordConstruct> getWordsbyPriority(boolean inputted) {
		return this.repo.getWordBypriorityWord(inputted);
	}

	public List<WordConstruct> getWordsbyMemorised(boolean inputted) {
		return this.repo.getWordBymemorisedWord(inputted);
	}

	public WordConstruct updatePriority(Integer word_id, WordConstruct www) {
		WordConstruct toPrioritise = this.returnWordID(word_id);
		toPrioritise.setPriorityWord(www.isPriorityWord());
		return this.repo.save(toPrioritise);
	}

	public boolean deleteWord(Integer word_id) {
		this.repo.deleteById(word_id);
		return !this.repo.existsById(word_id);
	}

	public List<ForeignWordEntry> getForeignWords() {
		return this.repo.findAllBy();
	}

	public List<WordConstruct> returnAllWords() {
		return this.repo.findAll();
	}

	public List<WordConstruct> getWordsbyCategoryPriority(String category, boolean priority) {
		return this.repo.getWordBywordCategorywordPriority(category, priority);
	}

	public WordConstruct replaceWordElements(Integer id, WordConstruct www) {
		WordConstruct word = this.searchforWordWithID(id);
		word.setForeignWord(www.getForeignWord());
		word.setWordType(www.getWordType());
		word.setWordTranslation(www.getWordTranslation());
		word.setWordCategory(www.getWordCategory());
		word.setPriorityWord(www.isPriorityWord());
		word.setMemorisedWord(www.isMemorisedWord());

		return this.repo.save(word);
	}

}
