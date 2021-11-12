package com.qa.languages.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.qa.languages.domain.WordConstruct;

@SpringBootTest
public class WordServiceDBTest {

	private WordConstruct word;

	@Autowired
	private WordServiceDB service;

	@BeforeEach
	public void init() {
		word = new WordConstruct(1, "yosomisuru", "verb", "to look away", "everyday", true, false);
		this.service.addNewWord(word);
	}

	@Test
	public void testType() {
		assertTrue("TRUE", word instanceof WordConstruct);
	}

	@Test
	public void returnWordIDTest() {
		assertThat(word).usingRecursiveComparison().isEqualTo(this.service.returnWordID(word.getId()));
	}

	@Test
	public void getForeignWordTest() {
		List<WordConstruct> wordList = List.of(word);
		assertThat(wordList).usingRecursiveComparison().isEqualTo(this.service.getForeignWord(word.getForeignWord()));
	}

	@Test
	public void getWordsbyTypeTest() {
		List<WordConstruct> wordList = List.of(word);
		assertThat(wordList).usingRecursiveComparison().isEqualTo(this.service.getWordsbyType(word.getWordType()));
	}

	@Test
	public void getWordsbyCategoryTypeTest() {
		List<WordConstruct> wordList = List.of(word);
		assertThat(wordList).usingRecursiveComparison()
				.isEqualTo(this.service.getWordsbyCategory(word.getWordCategory()));
	}

	@Test
	public void getWordsbyPriorityTest() {
		List<WordConstruct> wordList = List.of(word);
		assertThat(wordList).usingRecursiveComparison()
				.isEqualTo(this.service.getWordsbyPriority(word.isPriorityWord()));
	}

	@Test
	public void returnAllWordsTest() {
		List<WordConstruct> wordList = List.of(word);
		assertThat(wordList).usingRecursiveComparison().isEqualTo(this.service.returnAllWords());
	}

}
