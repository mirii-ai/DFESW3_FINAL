package com.qa.languages.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qa.languages.domain.WordConstruct;
import com.qa.languages.service.WordService;

@RequestMapping("/word")
@RestController
public class WordController {

	private WordService service;

	@Autowired
	public WordController(WordService service) {
		super();
		this.service = service;
	}

	@PostMapping("/add")
	public ResponseEntity<WordConstruct> addNewWord(@RequestBody WordConstruct newWord) {
		WordConstruct newItem = this.service.addNewWord(newWord);
		return new ResponseEntity<WordConstruct>(newItem, HttpStatus.CREATED);
	}

	@GetMapping("/retrieve/{word_id}") // search by word id
	public WordConstruct returnWordID(@PathVariable Integer word_id) {
		return this.service.searchforWordWithID(word_id);
	}

	@GetMapping("/retrieve/{wordSearch}") // search by word string
	public WordConstruct returnWord(@PathVariable String wordSearch) {
		return this.service.searchForWord(wordSearch);
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
}
