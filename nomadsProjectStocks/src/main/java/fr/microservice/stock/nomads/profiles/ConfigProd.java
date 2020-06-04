package fr.microservice.stock.nomads.profiles;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("configProd")//en développement seulement , pas en production 
@Component
@PropertySource("classpath:/application-prod.properties") 
public class ConfigProd {
	
	

	@PostConstruct()
	public void initData() {
		
	}
}
