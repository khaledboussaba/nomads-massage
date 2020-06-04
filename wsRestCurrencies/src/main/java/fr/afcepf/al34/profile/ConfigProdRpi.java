package fr.afcepf.al34.profile;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("configProdRpi")//en développement seulement , pas en production 
@Component
@PropertySource("classpath:application-prod-rpi.properties") 
public class ConfigProdRpi {
	
	

	@PostConstruct()
	public void initData() {
		
	}
}
