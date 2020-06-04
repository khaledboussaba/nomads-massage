package fr.afcepf.al34.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.dao.interfaces.ICurrenciesDao;
import fr.afcepf.al34.dto.CurrenciesDto;
import fr.afcepf.al34.entities.Currency;
import fr.afcepf.al34.entities.CurrencyInfo;
import fr.afcepf.al34.service.interfaces.ICurrenciesService;

@Service
public class CurrenciesService implements ICurrenciesService{

	@Autowired
	private ICurrenciesDao currencyDao;
	
	@Override
	public long initializeDatabase(CurrenciesDto currenciesDto) {
		
		Timestamp stamp = new Timestamp(currenciesDto.getTimestamp()*1000);
		Date lastUpdate = new Date(stamp.getTime());
		
		currenciesDto.getRates().forEach(
			(name,value)->{
				CurrencyInfo currencyInfo=new CurrencyInfo(name,lastUpdate);
				currencyDao.save(new Currency(name,value,currencyInfo));
			}
		);
		return getNbrCurrencies();
	}

	@Override
	public long getNbrCurrencies() {
		return currencyDao.count();
	}

	@Override
	public CurrenciesDto getAllCurrenciesDto() {
		CurrenciesDto currenciesDto=new CurrenciesDto();
		currenciesDto.setBase("EUR");
		currenciesDto.setDate(new Date());
		currenciesDto.setTimestamp(new Date().getTime());
		
		List<Currency> currencies=(List<Currency>) currencyDao.findAll();
		
		for(Currency currency:currencies) {
			currenciesDto.getRates().put(currency.getName(), currency.getValue());
			currenciesDto.getRatesInfo().put(currency.getCurrencyInfo().getName(), currency.getCurrencyInfo());
		}
		
		if(currenciesDto.getRates().size()==0) {
			currenciesDto.setSuccess(false);
		}else {
			currenciesDto.setSuccess(true);
		}
		
		return currenciesDto;
	}

	@Override
	public Currency getCurrency(String currencyString) {
		Currency currency=currencyDao.findByName(currencyString);
		return currency;
	}

}
