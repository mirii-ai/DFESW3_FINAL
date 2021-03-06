package com.qa.languages.rest;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.delete;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.patch;
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
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.ResultMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.qa.languages.domain.WordConstruct;

@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
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

		WordConstruct responseBody = new WordConstruct(2, "kettaku", "noun", "conspiracy", "everyday", true, false);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStatus = status().isCreated();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);

		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}

	@Test
	void testReturnAllWords() throws Exception {
		RequestBuilder request = get("/word/retrieveAll");

		ResultMatcher checkStatus = status().isOk();

		WordConstruct foundWord = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> wordList = List.of(foundWord);
		String responseBody = this.mapper.writeValueAsString(wordList);

		ResultMatcher checkBody = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checkBody);
	}
//FOR SOME REASON THE TABLE DOES NOT CLEAR ITSELF/ DOES NOT READ THE WORD-DATA SQL FILE!

	@Test
	void testRetrieveForeignWord() throws Exception {
		RequestBuilder request = get("/word/retrieveForeignWord/sakashii");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
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
	}

	@Test
	void testGetWordsbyCategory() throws Exception {
		RequestBuilder request = get("/word/category/everyday");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testGetWordsbyType() throws Exception {
		RequestBuilder request = get("/word/type/adj");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testgetIdByWord() throws Exception {
		RequestBuilder request = get("/word/getIDbyWord/sakashii");
		ResultMatcher checkStatus = status().isOk();
		Integer recovered = 1;
		String responseBody = this.mapper.writeValueAsString(recovered);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testGetWordsbyPriority() throws Exception {
		RequestBuilder request = get("/word/priority/true");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testGetWordsbyMemorise() throws Exception {
		RequestBuilder request = get("/word/memorised/false");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testGetWordsbyCategoryPriority() throws Exception {
		RequestBuilder request = get("/word/category_priority/everyday_true");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testGetWordsbyCategoryType() throws Exception {
		RequestBuilder request = get("/word/category_type/everyday_adj");
		ResultMatcher checkStatus = status().isOk();
		WordConstruct recovered = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				false);
		List<WordConstruct> newList = List.of(recovered);
		String responseBody = this.mapper.writeValueAsString(newList);
		ResultMatcher checker = content().json(responseBody);
		this.mvc.perform(request).andExpect(checkStatus).andExpect(checker);
	}

	@Test
	void testUpdateMemorised() throws Exception {
		WordConstruct requestBody = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				true);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);
		RequestBuilder replaceRequest = patch("/word/memorised/1").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		WordConstruct responseBody = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true,
				true);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStuff = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);
		this.mvc.perform(replaceRequest).andExpect(checkStuff).andExpect(checkBody);
	}

	@Test
	void testUpdatePriority() throws Exception {
		WordConstruct requestBody = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", false,
				false);
		String requestBodyAsJSON = this.mapper.writeValueAsString(requestBody);
		RequestBuilder replaceRequest = patch("/word/priority/1").contentType(MediaType.APPLICATION_JSON)
				.content(requestBodyAsJSON);

		WordConstruct responseBody = new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", false,
				false);
		String responseBodyAsJSON = this.mapper.writeValueAsString(responseBody);

		ResultMatcher checkStuff = status().isAccepted();
		ResultMatcher checkBody = content().json(responseBodyAsJSON);
		this.mvc.perform(replaceRequest).andExpect(checkStuff).andExpect(checkBody);
	}

	@Test
	void testDelete() throws Exception {
		this.mvc.perform(delete("/word/delete/1")).andExpect(status().isNoContent());
	}

	@Test
	void testDeleteWordByWord() throws Exception {
		this.mvc.perform(delete("/word/delete/word/sakashii")).andExpect(status().isNoContent());
	}
// new WordConstruct(1, "sakashii", "adj", "intelligent/clever", "everyday", true, false)); //THIS IS WHAT SHOULD BE IN THE TESTS??
}
