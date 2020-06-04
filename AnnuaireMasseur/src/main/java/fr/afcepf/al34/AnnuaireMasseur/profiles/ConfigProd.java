package fr.afcepf.al34.AnnuaireMasseur.profiles;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import fr.afcepf.al34.AnnuaireMasseur.IService.ISpecialiteService;

@Profile("configProd")//en développement seulement , pas en production 
@Component
@PropertySource("classpath:/application-prod.properties") 
public class ConfigProd {
	
	@Autowired
	ISpecialiteService speServ;

	@PostConstruct()
	public void initData() throws Exception {
//		if(speServ.getAllSpecialtes().size()==0) {
//			Thread.sleep(15000);
//			throw( new Exception());
//			
//		}
	}
}
