package fr.microservice.stock.nomads;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GestionStocksApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(GestionStocksApplication.class);

		application.run(args);

		System.out.println("http://localhost:900");
	}

}
