package fr.afcepf.al34.service.interfaces;

import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.entities.Currency;

public interface ICurrenciesService {

	long initializeDatabase(CurrenciesDto currenciesDto);

	long getNbrCurrencies();

	CurrenciesDto getAllCurrenciesDto();

	Currency getCurrency(String currency);

}
