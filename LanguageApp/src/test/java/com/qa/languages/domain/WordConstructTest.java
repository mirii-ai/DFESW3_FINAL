package com.qa.languages.domain;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class WordConstructTest {

	public WordConstruct testWord;

	@BeforeEach
	public void setUp() {
		testWord = new WordConstruct(1, "shimikomu", "verb", "to soak into/ to permeate", "everyday", true, false);
	}

	@Test
	public void testType() {
		assertTrue("TRUE", testWord instanceof WordConstruct);
	}

	@Test
	public void getForeignWordTest() {
		assertEquals("shimikomu", testWord.getForeignWord());
	}

	@Test
	public void getWordTypeTest() {
		assertEquals("verb", testWord.getWordType());
	}

	@Test
	public void getWordCategoryTest() {
		assertEquals("everyday", testWord.getWordCategory());
	}

	@Test
	public void setGetWordCategoryTest() {
		testWord.setWordCategory("society");
		assertEquals(testWord.getWordCategory(), "society");
	}

	@Test
	public void getWordTranslationTest() {
		assertEquals("to soak into/ to permeate", testWord.getWordTranslation());
	}

	@Test
	public void isMemorisedWordTest() {
		assertEquals(false, testWord.isMemorisedWord());
	}

	@Test
	public void isPriorityWordTest() {
		assertEquals(true, testWord.isPriorityWord());
	}

	@Test
	public void setIsMemorisedWordTest() {
		testWord.setMemorisedWord(true);
		assertEquals(true, testWord.isMemorisedWord());
	}

	@Test
	public void setGetForeignWordTest() {
		testWord.setForeignWord("keikai");
		assertEquals(testWord.getForeignWord(), "keikai");
	}

	@Test
	public void setGetWordTypeTest() {
		testWord.setWordType("noun");
		assertEquals(testWord.getWordType(), "noun");
	}

	@Test
	public void setGetWordTranslationTest() {
		testWord.setWordTranslation("caution/ vigilance");
		assertEquals(testWord.getWordTranslation(), "caution/ vigilance");
	}

	@Test
	public void TestWordConstructTest() {
		WordConstruct newWord = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true, false);
		assertTrue("TRUE", newWord instanceof WordConstruct);
	}
}
