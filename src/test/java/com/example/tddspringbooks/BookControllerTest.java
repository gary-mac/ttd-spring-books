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
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;

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
	private BookRequest.BookService bookService;

	@Test
	void testCreating_newBookEntry() {

		BookRequest bookRequest = new BookRequest();
		bookRequest.setAuthor("");
		bookRequest.setTitle("");
		bookRequest.setIsbn("");

		when(bookService.createNewBook(argumentCaptor.capture())).thenReturn(1L);
	}

}
