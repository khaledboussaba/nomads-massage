package fr.afcepf.al34.nomads.business.impl;

import java.net.ConnectException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.entities.Currency;
import fr.afcepf.al34.nomads.business.CurrenciesBusiness;
import fr.afcepf.al34.nomads.service.CurrenciesService;

@Service
public class CurrenciesBusinessImpl implements CurrenciesBusiness {
	String base = "EUR";
	List<String> currencies = new ArrayList<String>();
	Currency selectedCurrency;

	@Autowired
	CurrenciesService currenciesService;

	boolean serviceDisabled;
	
	@PostConstruct
	private void initaliseCurrencies() {

		try {
			System.out.println("try to initialise currency");
			selectedCurrency = currenciesService.getCurrency(base);
			CurrenciesDto currenciesDto = currenciesService.getAllCurrencies(base);

			currenciesDto.getRates().forEach((name, value) -> {
				currencies.add(name);
			});

			Collections.sort(currencies);
			serviceDisabled=false;
			System.out.println("initialise currency succes serviceDisabled="+serviceDisabled);
			
		} catch (Exception e) {
			serviceDisabled=true;
			selectedCurrency=new Currency();
			selectedCurrency.setName("EUR");
			selectedCurrency.setValue(1D);
			System.out.println("initialise currency failure serviceDisabled="+serviceDisabled);
		}
	}

	@Override
	public List<String> getAllCurrencies() {
		return currencies;
	}

	@Override
	public void selectCurrency(String currencyString) {
		try {
			System.out.println("try to selectCurrency");
			if(serviceDisabled==true) {
				initaliseCurrencies();
			}
			selectedCurrency = currenciesService.getCurrency(currencyString);
			serviceDisabled=false;
			System.out.println("selectCurrency succes serviceDisabled="+serviceDisabled);
		} catch (Exception e) {
			serviceDisabled=true;
			selectedCurrency=new Currency();
			selectedCurrency.setName("EUR");
			selectedCurrency.setValue(1D);
			System.out.println("selectCurrency failure serviceDisabled="+serviceDisabled);
		}
	}

	private Double convert(Double amount) {
		return amount * selectedCurrency.getValue();
	}

	@Override
	public String getAmount(Double amount) {
		Double retDouble = convert(amount);
		String formatted = String.format("%.2f", retDouble);
		if (selectedCurrency.getName().equalsIgnoreCase(base)) {
			formatted = formatted + " €";
		} else {
			formatted = formatted + " (" + selectedCurrency.getName() + ")";
		}
		return formatted;
	}

	public Currency getSelectedCurrency() {
		return selectedCurrency;
	}
	
	@Override
	public boolean isServiceDisabled() {
		if(serviceDisabled==true) {
			initaliseCurrencies();
		}
		return serviceDisabled;
	}

}
