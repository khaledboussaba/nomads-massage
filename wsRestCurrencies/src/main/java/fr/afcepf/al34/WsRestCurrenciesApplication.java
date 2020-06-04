package fr.afcepf.al34;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@SpringBootApplication
@EnableScheduling
@ComponentScan(basePackages = "fr.afcepf.al34")
public class WsRestCurrenciesApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WsRestCurrenciesApplication.class);
		
	    application.run(args);
	    System.out.println("http://localhost:91");

	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {

		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**");
			}
		};
	}
}
