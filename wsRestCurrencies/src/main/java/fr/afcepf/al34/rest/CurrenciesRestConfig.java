package fr.afcepf.al34.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.entities.Currency;
import fr.afcepf.al34.service.interfaces.ICurrenciesService;

@RestController
@RequestMapping(value = "/api/currencies", headers = "Accept=application/json")
public class CurrenciesRestConfig {

	@Autowired
	private ICurrenciesService currenciesService;
	
	@RequestMapping(value = "/latest", method = RequestMethod.GET)
	public CurrenciesDto getAllCurrencies() {
		return currenciesService.getAllCurrenciesDto();
		
	}
	
	@RequestMapping(value = "/latest/{currency}", method = RequestMethod.GET)
	public Currency getCurrency(@PathVariable String currency) {
		return currenciesService.getCurrency(currency);
		
	}
	
	

}
