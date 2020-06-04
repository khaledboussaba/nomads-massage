package fr.afcepf.al34.nomads.ws.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.service.AdresseService;
import fr.afcepf.al34.nomads.dao.AdresseDao;
import fr.afcepf.al34.nomads.entities.Adresse;

@Service
public class AdresseServiceImpl implements AdresseService {

	@Autowired
	private AdresseDao proxyDao;
	
	@Override
	public Adresse ajouterUneNouvelleAdresse(Adresse adresse) {
		return proxyDao.insert(adresse);
	}

}
