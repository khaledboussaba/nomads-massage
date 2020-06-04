package fr.afcepf.al34.nomads.web.beans;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.faces.event.ValueChangeEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CurrenciesBusiness;
import lombok.NoArgsConstructor;

@ManagedBean(value = "mbCurrencies")
@SessionScope
@NoArgsConstructor 
public class CurrenciesManagedBean {

	@Autowired
	CurrenciesBusiness currenciesBusiness;
	
	public boolean isServiceEnabled() {
		return !currenciesBusiness.isServiceDisabled();
	}
	
	public String getCurrentCurrencyName() {
		String name=currenciesBusiness.getSelectedCurrency().getName();
		return name;
	}
	public void setCurrentCurrencyName(String currencyName) {
		selectCurrency(currencyName);
	}
	public List<String> getAllCurrenciesName(){
		return currenciesBusiness.getAllCurrencies();
	}
	
	public String convert(Double amount) {
		return currenciesBusiness.getAmount(amount);
	}
	public void  currencyChanged(ValueChangeEvent event) {
	    selectCurrency(event.getNewValue().toString());
	}
	public void selectCurrency(String currencyName) {
		currenciesBusiness.selectCurrency(currencyName);
	}
}
