package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.entities.Currency;


public interface CurrenciesBusiness {
	List<String> getAllCurrencies();

	void selectCurrency(String currencyString);

	String getAmount(Double amount);

	Currency getSelectedCurrency();

	boolean isServiceDisabled();
}
