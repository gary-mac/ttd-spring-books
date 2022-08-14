package com.example.tddspringbooks;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.mock.mockito.MockBeans;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;

@WebMvcTest(BookController.class)
@ExtendWith(SpringExtension.class)
class BookControllerTest {

	@Autowired
	private MockMvc mockMvc;

	@Autowired
	private ObjectMapper objectMapper;

	@Captor
	private ArgumentCaptor<BookRequest> argumentCaptor;

	@MockBean
	private BookService bookService;

	@Test
	void testCreating_newBookEntry() throws Exception {

		BookRequest bookRequest = new BookRequest();
		bookRequest.setTitle("Refactoring");
		bookRequest.setAuthor("Martin Fowler");
		bookRequest.setIsbn("1234");

		when(bookService.createNewBook(argumentCaptor.capture())).thenReturn(1L);

		this.mockMvc.perform(post("/api/books")
				.contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(bookRequest)))
				.andExpect(header().exists("Location"))
				.andExpect(header().string("Location", "http://localhost/api/books/1"));

		assertThat(argumentCaptor.getValue().getTitle(), is("Refactoring"));
		assertThat(argumentCaptor.getValue().getAuthor(), is("Martin Fowler"));
		assertThat(argumentCaptor.getValue().getIsbn(), is("1234"));

	}

}
