package com.qa.languages.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.languages.domain.WordConstruct;
import com.qa.languages.service.WordServiceDB;

@RequestMapping("/word")
@RestController
public class WordController {

	private WordServiceDB service;

	@Autowired
	public WordController(WordServiceDB service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<WordConstruct> addNewWord(@RequestBody WordConstruct newWord) {
		WordConstruct newItem = this.service.addNewWord(newWord);
		return new ResponseEntity<WordConstruct>(newItem, HttpStatus.CREATED);
	}

	@GetMapping("/retrieve/{word_id}") // search by word id
	public ResponseEntity<WordConstruct> returnWordID(@PathVariable Integer word_id) {
		return new ResponseEntity<WordConstruct>(this.service.searchforWordWithID(word_id), HttpStatus.OK);
	}

	@PatchMapping("/memorised/{word_id}") // patch mapping- updates not puts. you don't change the data, updating things
											// that already exist
	// no ability to change to null
	public ResponseEntity<WordConstruct> updateMemorised(@PathVariable Integer word_id, @RequestBody WordConstruct w) {
		return new ResponseEntity<WordConstruct>(this.service.updateMemoriseWord(word_id, w), HttpStatus.ACCEPTED);
	}

	@PatchMapping("/priority/{word_id}")
	public ResponseEntity<WordConstruct> updatePriority(@PathVariable Integer word_id, @RequestBody WordConstruct www) {
		return new ResponseEntity<WordConstruct>(this.service.updatePriority(word_id, www), HttpStatus.ACCEPTED);
	}

	@DeleteMapping("/delete/{word_id}")
	public ResponseEntity<?> deleteWord(@PathVariable Integer word_id) {
		boolean beenRemoved = this.service.deleteWord(word_id);
		if (beenRemoved) {
			return new ResponseEntity<>("Removed from your list.", HttpStatus.NO_CONTENT);
		} else {
			return new ResponseEntity<>("Execution of deletion failed", HttpStatus.EXPECTATION_FAILED);
		}
	}

	@GetMapping("/category/{category}")
	public ResponseEntity<List<WordConstruct>> getWordsByCategory(@PathVariable String category) {
		return new ResponseEntity<>(this.service.getWordsbyCategory(category), HttpStatus.OK);
	}

	@GetMapping("/type/{type}")
	public ResponseEntity<List<WordConstruct>> getWordsByType(@PathVariable String type) {
		return new ResponseEntity<>(this.service.getWordsbyType(type), HttpStatus.OK);
	}

	@GetMapping("/category_type/{category}_{type}")
	public ResponseEntity<List<WordConstruct>> getWordsbyCategoryType(@PathVariable String category,
			@PathVariable String type) {
		return new ResponseEntity<>(this.service.getWordsbyCategoryType(category, type), HttpStatus.OK);
	}

	@GetMapping("/priority/{inputted}")
	public ResponseEntity<List<WordConstruct>> getWordsbyPriority(@PathVariable boolean inputted) {
		return new ResponseEntity<>(this.service.getWordsbyPriority(inputted), HttpStatus.OK);
	}

	@GetMapping("/memorised/{inputted}")
	public ResponseEntity<List<WordConstruct>> getWordsbyMemorised(@PathVariable boolean inputted) {
		return new ResponseEntity<>(this.service.getWordsbyMemorised(inputted), HttpStatus.OK);
	}

}
