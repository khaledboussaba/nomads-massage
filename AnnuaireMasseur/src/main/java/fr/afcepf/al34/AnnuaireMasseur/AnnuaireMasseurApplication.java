package fr.afcepf.al34.AnnuaireMasseur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AnnuaireMasseurApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(AnnuaireMasseurApplication.class);

		application.run(args);
	}

}
