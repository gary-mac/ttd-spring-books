package com.example.tddspringbooks;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@WebMvcTest(BookController.class)
@ExtendWith(SpringExtension.class)
class BookControllerTest {

	@Test
	void contextLoads() {
	}

}
