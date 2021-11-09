package com.qa.languages.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class WordConstruct {

	@Id // primary key identifier
	@GeneratedValue(strategy = GenerationType.IDENTITY) // establishes auto-increment for Id column
	private Integer Id; // auto increments- for database management. Doesn't have any impact on the
						// database itself but can be used to notify user of how many entries they've
						// submitted.
	private String foreignWord;
	private String wordType; // verb, adjective, noun, adverb etc
	private String wordTranslation;
	private String wordCategory; // environment, politics, shopping etc
	private boolean priorityWord; // boolean default false, but can be made true if user wishes
	private boolean memorisedWord = false; // boolean memorisedWord=false , can change later. why would the user put
											// true
	// if they're putting it in the app in the first place? Assumed false.

	public WordConstruct(String foreignWord, String wordType, String wordTranslation, String wordCategory,
			boolean priorityWord) {
		super();
		this.foreignWord = foreignWord;
		this.wordType = wordType;
		this.wordTranslation = wordTranslation;
		this.wordCategory = wordCategory;
		this.priorityWord = priorityWord;
	}

	public WordConstruct(Integer Id, String foreignWord, String wordType, String wordTranslation, String wordCategory,
			boolean priorityWord) {
		super();
		this.Id = Id;
		this.foreignWord = foreignWord;
		this.wordType = wordType;
		this.wordTranslation = wordTranslation;
		this.wordCategory = wordCategory;
		this.priorityWord = priorityWord;
	}

	public WordConstruct() {
		super();
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getForeignWord() {
		return foreignWord;
	}

	public void setForeignWord(String foreignWord) {
		this.foreignWord = foreignWord;
	}

	public String getWordType() {
		return wordType;
	}

	public void setWordType(String wordType) {
		this.wordType = wordType;
	}

	public String getWordTranslation() {
		return wordTranslation;
	}

	public void setWordTranslation(String wordTranslation) {
		this.wordTranslation = wordTranslation;
	}

	public String getWordCategory() {
		return wordCategory;
	}

	public void setWordCategory(String wordCategory) {
		this.wordCategory = wordCategory;
	}

	public boolean isPriorityWord() {
		return priorityWord;
	}

	public void setPriorityWord(boolean priorityWord) {
		this.priorityWord = priorityWord;
	}

	public boolean isMemorisedWord() {
		return memorisedWord;
	}

	public void setMemorisedWord(boolean memorisedWord) {
		this.memorisedWord = memorisedWord;
	}

	@Override
	public String toString() {
		return "WordConstruct [Id=" + Id + ", foreignWord=" + foreignWord + ", wordType=" + wordType
				+ ", wordTranslation=" + wordTranslation + ", wordCategory=" + wordCategory + ", priorityWord="
				+ priorityWord + ", memorisedWord=" + memorisedWord + "]";
	}

}
