package es.iesrafaelalberti.boardgameApi;

import es.iesrafaelalberti.boardgameApi.config.RsaKeyProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(RsaKeyProperties.class)
public class PruebaApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebaApiApplication.class, args);
	}

}
