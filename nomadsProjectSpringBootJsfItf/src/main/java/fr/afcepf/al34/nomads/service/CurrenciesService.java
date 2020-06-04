package fr.afcepf.al34.nomads.service;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.entities.Currency;

public interface CurrenciesService {
	CurrenciesDto getAllCurrencies(String base) throws Exception;
	Currency getCurrency(String currencyString)  throws Exception;
}
