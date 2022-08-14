package com.example.tddspringbooks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class BookControllerTest {

	@Autowired
	MockMvc mockMvc;

	@MockBean
	private BookService bookService;

	@Test
	void getAllBooks() throws Exception {
		List<Book> book = new ArrayList<Book>();
		book.add(new Book("Refactoring", "Martin Fowler", "1234"));

		when(bookService.findAll()).thenReturn(book);

		mockMvc.perform(MockMvcRequestBuilders.get("/books")
				.contentType(MediaType.APPLICATION_JSON)
		).andExpect(jsonPath("$", hasSize(1))).andDo(print());
	}
}
