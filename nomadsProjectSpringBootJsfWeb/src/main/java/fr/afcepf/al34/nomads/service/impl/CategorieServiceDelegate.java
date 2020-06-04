package fr.afcepf.al34.nomads.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.service.CategorieService;
import fr.microservice.stock.nomads.entities.Categorie;

@Service
public class CategorieServiceDelegate implements CategorieService {

	@Value(value = "${stock-api.base-url}")
	protected String baseStockUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	ObjectMapper jsonMapper = new ObjectMapper();
	
	@Override
	public Categorie getCategorieById(Long id) {
		Categorie categorie = restTemplate.getForObject(baseStockUrl+"/stock-api/public/categorie/"+id, Categorie.class);
		return categorie;
	}

}
