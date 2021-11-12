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

	// RETURNS THE WORD/ENTRY BY ID! Does not return the ID itself.
	public WordConstruct returnWordID(Integer word_id) {
		Optional<WordConstruct> optionalWord = this.repo.findById(word_id);
		if (optionalWord.isPresent()) {
			WordConstruct returnedWord = optionalWord.get();
			return returnedWord;
		} else {
			throw new EntityNotFoundException("No word with this ID has been found in the database.");
		}
	}

	// Adds new entry to the database
	public WordConstruct addNewWord(WordConstruct newWord) {
		return this.repo.save(newWord);
	}

	// Gets the entry by searching the foreign word
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

	// Returns a list of everything in the database
	public List<WordConstruct> getWords() {
		return this.repo.findAll();
	}

	// returns words by category search
	public List<WordConstruct> getWordsbyCategory(String category) {
		return this.repo.getWordBywordCategory(category);
	}

	// returns words by type search (eg, verbs)
	public List<WordConstruct> getWordsbyType(String type) {
		return this.repo.getWordBywordType(type);
	}

	// returns words by category and type (eg, everyday adj)
	public List<WordConstruct> getWordsbyCategoryType(String category, String type) {
		return this.repo.getWordBywordCategorywordType(category, type);
	}

	// returns words by whether they're priority words or not
	public List<WordConstruct> getWordsbyPriority(boolean inputted) {
		return this.repo.getWordBypriorityWord(inputted);
	}

	// return memorised words (or words not memorised yet)
	public List<WordConstruct> getWordsbyMemorised(boolean inputted) {
		return this.repo.getWordBymemorisedWord(inputted);
	}

	// updates priority status
	public WordConstruct updatePriority(Integer word_id, WordConstruct www) {
		WordConstruct toPrioritise = this.returnWordID(word_id);
		toPrioritise.setPriorityWord(www.isPriorityWord());
		return this.repo.save(toPrioritise);
	}

	// deletes entry by ID
	public boolean deleteWord(Integer word_id) {
		this.repo.deleteById(word_id);
		return !this.repo.existsById(word_id);
	}

	// deletes entry by word
	public boolean deleteWordByWord(String foreignWord) {
		Integer word_id = getIdByWord(foreignWord);
		this.repo.deleteById(word_id);
		return !this.repo.existsById(word_id);
	}

	// returns a reduced list of the foreign word, the category and the word type
	// only
	public List<ForeignWordEntry> getForeignWords() {
		return this.repo.findAllBy();
	}

	// returns all words
	public List<WordConstruct> returnAllWords() {
		return this.repo.findAll();
	}

	// returns words by category and priority
	public List<WordConstruct> getWordsbyCategoryPriority(String category, boolean priority) {
		return this.repo.getWordBywordCategorywordPriority(category, priority);
	}

	// updates elements of an entry
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

	// finds ID by word input
	public Integer getIdByWord(String foreignWord) {
		return this.repo.getIdByforeignWord(foreignWord);
	}

}
