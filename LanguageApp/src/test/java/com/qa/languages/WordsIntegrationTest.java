package com.qa.languages;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
//import static org.springframework.test.web.client.match.MockRestRequestMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.languages.domain.WordConstruct;

//@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
@SpringBootTest
@AutoConfigureMockMvc
@Sql(scripts = { "classpath:word-schema.sql",
		"classpath:word-data.sql" }, executionPhase = ExecutionPhase.BEFORE_TEST_METHOD)
@ActiveProfiles("test")
public class WordsIntegrationTest {

	@Autowired
	private MockMvc mvc;

	@Autowired
	private ObjectMapper mapper;

	@Test
	void testAddNewWord() throws Exception {
		WordConstruct requestBody = new WordConstruct("kettaku", "noun", "conspiracy", "everyday", true);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);
		RequestBuilder request = post("/word/add").contentType(MediaType.APPLICATION_JSON).content(requestBodyAsJSON);

		WordConstruct responseBody = new WordConstruct(1, "kettaku", "noun", "conspiracy", "everyday", true, false);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReturnAllWords() throws Exception {
		RequestBuilder request = get("/word/retrieveAll");

		ResultMatcher checkStatus = status().isOk();

		WordConstruct foundWord = new WordConstruct(1, "kettaku", "noun", "conspiracy", "everyday", true, false);
		List<WordConstruct> wordList = List.of(foundWord);
		String responseBody = this.mapper.writeValueAsString(wordList);

		ResultMatcher checkBody = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
//FOR SOME REASON THE TABLE DOES NOT CLEAR ITSELF/ DOES NOT READ THE WORD-DATA SQL FILE!

	@Test
	void testRetrieveForeignWord() throws Exception {
		RequestBuilder request = get("/word/retrieveForeignWord/kettaku");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "kettaku", "noun", "conspiracy", "everyday", true, false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testReturnWordID() throws Exception {
		RequestBuilder request = get("/word/retrieve/1");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		WordConstruct newList = recovered;
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testReplaceWordElements() throws Exception {
		WordConstruct requestBody = new WordConstruct(1, "akireru", "verb", "to be amazed/ to be shocked", "everyday",
				true, false);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);
		RequestBuilder replaceRequest = put("/word/change/element/1").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		WordConstruct responseBody = new WordConstruct(1, "akireru", "verb", "to be amazed/ to be shocked", "everyday",
				true, false);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStuff = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);
		this.mvc.perform(replaceRequest).andExpect(checkStuff).andExpect(checkBody);

//		final String responseBody = this.mapper.writeValueAsString(
//				new WordConstruct(1, "akireru", "verb", "to be amazed/ to be shocked", "everyday", true, false));
//		RequestBuilder request = put("/word/change/element/1").contentType(MediaType.APPLICATION_JSON)
//				.content(responseBody);
//
//		ResultMatcher checkStatus = status().isAccepted();
//		ResultMatcher checkBody = content().json(responseBody);
//
//		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/word/delete/1")).andExpect(status().isNoContent());
	}

	@Test
	void testGetWordsbyPriority() throws Exception {
		RequestBuilder request = get("/word/priority/true");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "kettaku", "noun", "conspiracy", "everyday", true, false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);

	}
// new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true, false)); //THIS IS WHAT SHOULD BE IN THE TESTS??
}
