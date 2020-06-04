package fr.afcepf.al34.nomads.ws.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.service.LigneCommandeService;
import fr.afcepf.al34.nomads.dao.LigneCommandeDao;
import fr.afcepf.al34.nomads.entities.LigneCommande;

@Service
public class LigneCommandeServiceImpl implements LigneCommandeService {
	
	@Autowired
	private LigneCommandeDao proxyDao ; 

	@Override
	public void enregisterLigneCommande(LigneCommande ligneCommande) {
		
		proxyDao.insert(ligneCommande);
	}

	@Override
	public Long recupererLeNombreDeCreditAcrediter(Long id) {
		return proxyDao.getNombreDeCreditAcrediter(id);
	}

}
