package es.iesrafaelalberti.boardgameApi;

import es.iesrafaelalberti.boardgameApi.repository.BoardgameRepository;
import es.iesrafaelalberti.boardgameApi.repository.CommentRepository;
import es.iesrafaelalberti.boardgameApi.repository.PublisherRepository;
import es.iesrafaelalberti.boardgameApi.repository.UserRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.security.test.web.servlet.request.SecurityMockMvcRequestPostProcessors.httpBasic;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@SpringBootTest
@AutoConfigureMockMvc
class BoardgameApiApplicationTests {
	@Autowired
	MockMvc mvc;
	@Autowired
	BoardgameRepository boardgameRepository;
	@Autowired
	PublisherRepository publisherRepository;
	@Autowired
	UserRepository userRepository;
	@Autowired
	CommentRepository commentRepository;
	/*@Test
	void rootWhenUnauthenticatedThen401() throws Exception {
		this.mvc.perform(get("/boardgames"))
				.andExpect(status().isUnauthorized());
	} */
	@Test
	void contextLoads() {
		assert boardgameRepository.count() == 8;
		assert publisherRepository.count() == 3;
		assert commentRepository.count() == 10;
	}
	@Test
	void listTest() throws Exception {
		MvcResult result = this.mvc.perform(post("/token")
				.with(httpBasic("dmardom","pestillo1")))
				.andExpect(status().isOk())
				.andReturn();
		String token = result.getResponse().getContentAsString();



		mvc.perform(get("/boardgames")
						.header("Authorization","Bearer " + token)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
	}
	@Test
	void creationTest() throws Exception {
		MvcResult result = this.mvc.perform(post("/token")
						.with(httpBasic("dmardom","pestillo1")))
				.andExpect(status().isOk())
				.andReturn();

		String token = result.getResponse().getContentAsString();

		long boardgameCount = boardgameRepository.count();
		// Create test boardgame
		String testBoardgame = "{\"name\": \"Bang!\", \"description\": \"Juego rápido y sencillo para toda la familia\", \"duration\": 25, \"difficulty\": \"Easy\" }";
		mvc.perform(post("/boardgames/create")
						.header("Authorization","Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)
				.content(testBoardgame))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("Bang!"))
				.andExpect(jsonPath("$.description").value("Juego rápido y sencillo para toda la familia"))
				.andExpect(jsonPath("$.duration").value(25))
				.andExpect(jsonPath("$.difficulty").value("Easy"));
		assert boardgameRepository.count() == boardgameCount + 1;
	}
	@Test
	void detailTest() throws Exception {
		MvcResult result = this.mvc.perform(post("/token")
						.with(httpBasic("dmardom","pestillo1")))
				.andExpect(status().isOk())
				.andReturn();

		String token = result.getResponse().getContentAsString();

		mvc.perform(get("/boardgames/1")
						.header("Authorization","Bearer " + token)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON));
				// Need to create a specific boardgame using seeders to complete this test



	}
	@Test
	void updateTest() throws Exception {
		MvcResult result = this.mvc.perform(post("/token")
						.with(httpBasic("dmardom","pestillo1")))
				.andExpect(status().isOk())
				.andReturn();

		String token = result.getResponse().getContentAsString();

		// Get test boardgame (method get on url /boardgames/1/)
		// Create test boardgame
		String testBoardgame = "{\"name\": \"Bang!\", \"description\": \"Juego rápido y sencillo para toda la familia\", \"duration\": 25, \"difficulty\": \"Easy\" }";
		// modify attributes
		// Method put on url /boardgames/1/
		mvc.perform(put("/boardgames/1")
						.header("Authorization","Bearer " + token)
				.contentType(MediaType.APPLICATION_JSON)
				.content(testBoardgame))
				.andExpect(status().isOk())
				.andExpect(content().contentTypeCompatibleWith(MediaType.APPLICATION_JSON))
				.andExpect(jsonPath("$.name").value("Bang!"))
				.andExpect(jsonPath("$.description").value("Juego rápido y sencillo para toda la familia"))
				.andExpect(jsonPath("$.duration").value(25))
				.andExpect(jsonPath("$.difficulty").value("Easy"));
		// test result
	}
	 @Test
	void deleteTest() throws Exception {
		 MvcResult result = this.mvc.perform(post("/token")
						 .with(httpBasic("dmardom","pestillo1")))
				 .andExpect(status().isOk())
				 .andReturn();

		 String token = result.getResponse().getContentAsString();

		long boardgameCount = boardgameRepository.count();
		mvc.perform(delete("/boardgames/1")
						.header("Authorization","Bearer " + token)
						.contentType(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk())
				.andExpect(content().string("true"));
		assert boardgameRepository.count() == boardgameCount -1;
	 }
}
