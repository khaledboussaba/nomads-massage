package fr.afcepf.al34.nomads.profiles;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import fr.afcepf.al34.nomads.service.ProduitService;

@Profile("configProd")//en développement seulement , pas en production 
@Component
@PropertySource("classpath:/application-prod.properties") 
public class ConfigProd {
	
	@PostConstruct()
	public void initData() throws Exception {
//		if(ps.recupererLeNombreFormulesPacks()==0) {
//			Thread.sleep(15000);
//			throw( new Exception());
//		}
	}
}
