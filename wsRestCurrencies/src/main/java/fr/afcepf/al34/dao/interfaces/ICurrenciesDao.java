package fr.afcepf.al34.dao.interfaces;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.entities.Currency;

public interface ICurrenciesDao extends CrudRepository<Currency, String>{
	Currency findByName(String name);
}
