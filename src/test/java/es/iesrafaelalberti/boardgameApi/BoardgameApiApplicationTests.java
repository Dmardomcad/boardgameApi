package es.iesrafaelalberti.boardgameApi;

import es.iesrafaelalberti.boardgameApi.repository.BoardgameRepository;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
class BoardgameApiApplicationTests {
	@Autowired
	MockMvc mvc;
	@Autowired
	BoardgameRepository boardgameRepository;
	@Autowired
	PublisherRepository publisherRepository;

	@Test
	void contextLoads() {
		assert boardgameRepository.count() == 10;
		assert publisherRepository.count() == 10;
	}

}
