package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dao.CatalogueDao;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.CatalogueService;

@Service
public class CatalogueServiceImpl implements CatalogueService {
	
	@Autowired
	private CatalogueDao proxyDao ; 
	
	private List<PackCredit> packsCredits; 
	private List<Tournee> tournees;
	private List<Materiel> materiels;
	
	

	@Override
	public List<Produit> afficherTousProduits() {
		return proxyDao.getAllProducts();
	}
	

	@Override
	public List<PackCredit> affichertousPacks() {
		return proxyDao.getAllPacks();
	}

	@Override
	public List<Tournee> afficherTousTournees() {
		return proxyDao.getAllTournees();
	}

	@Override
	public List<Materiel> afficheTousMateriels() {
		return proxyDao.getAllMateriels();
	}


	@Override
	public Produit recupererParIdProduit(int i) {
	
		return proxyDao.getProduitById(i);
	}

}
