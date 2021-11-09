package com.qa.languages.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.qa.languages.domain.WordConstruct;

@Repository
public interface WordRepo extends JpaRepository<WordConstruct, Integer> {

	// SELECT * FROM WordConstruct WHERE foreignword = '[word]';
	List<WordConstruct> findWordConstructByForeignWord(String word);

	// SELECT * FROM WordConstruct WHERE WordCategory = '[word]';
	List<WordConstruct> findWordConstructByWordCategory(String word);

	// Ask about selecting specific columns to return, not 'all'
	// ask about how to transfer this to the methods in the
	// controller/service/serviceDB
	// if i want to search by word all the time do I have to write queries for all
	// of them or is there another way
}
