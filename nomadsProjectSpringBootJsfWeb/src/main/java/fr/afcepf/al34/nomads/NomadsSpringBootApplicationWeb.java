package fr.afcepf.al34.nomads;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;

//NB: @SpringBootApplication est un équivalent
//de @Configuration + @EnableAutoConfiguration + @ComponentScan/current package
@SpringBootApplication
//NB: via le @EnableAutoConfiguration, application.properties sera analysé
//NB: cette classe doit être dans tp pour que le @ComponentScan automatique
// scrute tous les sous packages tp.dao, tp.service , ...
//@EnableAutoConfiguration
public class NomadsSpringBootApplicationWeb extends SpringBootServletInitializer {
	public static void main(String[] args) {
		// SpringApplication.run(MySpringBootApplication.class, args);
		SpringApplication application = new SpringApplication(NomadsSpringBootApplicationWeb.class);

		ConfigurableApplicationContext context = application.run(args);
		System.out.println(context);
		System.out.println("http://localhost:80/index.xhtml");
	}

	
}
