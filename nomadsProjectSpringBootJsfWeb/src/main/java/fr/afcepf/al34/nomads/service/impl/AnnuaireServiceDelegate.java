package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;
import fr.afcepf.al34.nomads.service.AnnuaireService;
import fr.microservice.stock.nomads.entities.Article;

@Service
public class AnnuaireServiceDelegate implements AnnuaireService {
	
	@Value(value = "${annuaire-api.base-url}")
	protected String baseAnnuaireUrl;
	
	private RestTemplate restTemplate = new RestTemplate();

	ObjectMapper jsonMapper = new ObjectMapper();

	@Override
	public List<Specialite> afficherToutesLesSpecialites() {
		Object tmp = restTemplate.getForObject(baseAnnuaireUrl+"/annuaireMasseur-api/public/specialites", List.class);
		JavaType type = jsonMapper.getTypeFactory().
				  constructCollectionType(List.class, Specialite.class);
		List<Specialite> specialites = jsonMapper.convertValue(tmp, type);
		
		return specialites;
	}

	
	
	
	
	
	
	
	
	

}
