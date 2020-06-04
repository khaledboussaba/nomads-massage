package fr.afcepf.al34.profile;

import javax.annotation.PostConstruct;

import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

@Profile("configEclipse")//en développement seulement , pas en production 
@Component
@PropertySource("classpath:application-eclipse.properties") 
public class ConfigEclipse {
	
	

	@PostConstruct()
	public void initData() {
		
	}
}
