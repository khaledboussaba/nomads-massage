package fr.afcepf.al34.cron;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.service.interfaces.ICurrenciesService;
import fr.afcepf.al34.tools.Log;

@Component
public class Cron {
	
	@Autowired
	private ICurrenciesService currenciesService;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	
	@Scheduled(fixedRate = 7200000, initialDelay = 7200000)//86400000)
	private void updateCurrencies() {
		long nbrCurrencies=0;
		Log.logger.info("Loading currencies from http://data.fixer.io/api/latest");
		CurrenciesDto currenciesDto = restTemplate.getForObject(
				"http://data.fixer.io/api/latest?access_key=1601c620f3aae83406a8cb2513cedcc0&format=1&base=EUR",
				CurrenciesDto.class);
		
		
		nbrCurrencies = currenciesService.initializeDatabase(currenciesDto);

		Log.logger.info("We start with " + nbrCurrencies + " currencies in database");
	}
}
