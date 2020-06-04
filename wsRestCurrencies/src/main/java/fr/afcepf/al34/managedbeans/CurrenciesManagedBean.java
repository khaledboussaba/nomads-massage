package fr.afcepf.al34.managedbeans;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al34.managedbeans.interfaces.ICurrenciesManagedBean;
import fr.afcepf.al34.service.interfaces.ICurrenciesService;
import lombok.NoArgsConstructor;

@ManagedBean("currenciesMb")
@NoArgsConstructor
public class CurrenciesManagedBean implements ICurrenciesManagedBean {
	
	@Autowired
	ICurrenciesService currenciesService;

	private long nbrCurrencies=0;

	public long getNbrCurrencies() {
		setNbrCurrencies(currenciesService.getNbrCurrencies());
		return nbrCurrencies;
	}

	public void setNbrCurrencies(long nbrCurrencies) {
		this.nbrCurrencies = nbrCurrencies;
	}
	
	
	
	
}
