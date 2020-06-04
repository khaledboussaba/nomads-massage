package fr.afcepf.al34.profile;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.service.interfaces.ICurrenciesService;
import fr.afcepf.al34.tools.Log;

@Profile("initData")//en développement seulement , pas en production 
@Component
public class InitDataSet {
	
	@Autowired
	private ICurrenciesService currenciesService;
	
	private RestTemplate restTemplate = new RestTemplate();

	@PostConstruct()
	public void initData() {
		long nbrCurrencies=0;
		nbrCurrencies=currenciesService.getNbrCurrencies();
		if(nbrCurrencies<=0) {
			Log.logger.info("Loading currencies from http://data.fixer.io/api/latest");
			CurrenciesDto currenciesDto = restTemplate.getForObject("http://data.fixer.io/api/latest?access_key=1601c620f3aae83406a8cb2513cedcc0&format=1&base=EUR", CurrenciesDto.class);
			
			nbrCurrencies=currenciesService.initializeDatabase(currenciesDto);
		}
		Log.logger.info("We start with "+nbrCurrencies+" currencies in database");
	}
}
