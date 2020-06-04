package fr.afcepf.al34.nomads.service.impl;

import java.net.ConnectException;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.entities.Currency;
import fr.afcepf.al34.nomads.service.CurrenciesService;

@Service
public class CurrenciesServiceImpl implements CurrenciesService {

	@Value(value = "${currencies-api.base-url}")
	protected String baseCurrencyUrl;
	
	private RestTemplate restTemplate = new RestTemplate();

	@Override
	public CurrenciesDto getAllCurrencies(String base) throws ConnectException {
		CurrenciesDto currenciesDto = restTemplate.getForObject(baseCurrencyUrl+"/currencies/latest?access_key=1601c620f3aae83406a8cb2513cedcc0&format=1&base=EUR", CurrenciesDto.class);
		return currenciesDto;
	}

	@Override
	public Currency getCurrency(String currencyString) throws ConnectException { 
		Currency currency = restTemplate.getForObject(baseCurrencyUrl+"/currencies/latest/"+currencyString+"?access_key=1601c620f3aae83406a8cb2513cedcc0&format=1&base=EUR", Currency.class);
		return currency;
	}

}
