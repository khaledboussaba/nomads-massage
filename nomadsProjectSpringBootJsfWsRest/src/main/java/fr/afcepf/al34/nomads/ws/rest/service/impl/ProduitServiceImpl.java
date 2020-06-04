package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.service.ProduitService;
import fr.afcepf.al34.nomads.dao.ProduitDao;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;

@Service
public class ProduitServiceImpl implements ProduitService {

	@Autowired
	private ProduitDao proxyDao;
	
	@Override
	public List<Produit> recupererLaListeDesTshirt() {
		return proxyDao.getTshirtsList();
	}

	@Override
	public List<Produit> recupererLaListeDesPacks() {
		return proxyDao.getPacksList();
	}

	@Override
	public Long recupererLeNombreDeTshirtDisponile() {
		return proxyDao.getCountTshirtInStock();
	}

	@Override
	public Long recupererLeNombreDeTPEdisponile() {
		return proxyDao.getCountTPEinStock();
	}

	@Override
	public Long recupererLeNombreFormulesPacks() {
		return proxyDao.getCountPacksFormules();
	}

	@Override
	public Long recupererLeNombreDeChaisesdisponile() {
		return proxyDao.getCountChaises();
	}

	@Override
	public List<Produit> recupererLaListeDesTPE() {
		return proxyDao.getAllTPE();
	}

	@Override
	public List<Produit> recupererLaListeDesChaises() {
		return proxyDao.getAllChaises();
	}

	@Override
	public Long recupererLeNombreDeBarActifs() {
		return proxyDao.getCountActiveBars();
	}

	@Override
	public Long recupererLeNombreDeBarEnAttente() {
		return proxyDao.getCountBarsEnAttente();
	}

	@Override
	public Long recupererLeNombreDeBarInactifs() {
		return proxyDao.getCountInactiveBars();
	}

	@Override
	public Long recupererLeNombreDeMasseursActifs() {
		return proxyDao.getCountMasseursActif();
	}

	@Override
	public Long recupererLeNombreDeMasseursInactifs() {
		return proxyDao.getCountMasseursInactif();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenir() {
		return proxyDao.getCountTourneesAVenir();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtComplete() {
		return proxyDao.getCountTourneesAVenirEtComplete();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtSemiComplete() {
		return proxyDao.getCountTourneesAVenirEtSemiComplete();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtVide() {
		return proxyDao.getCountTourneesAVenirEtVide();
	}

	@Override
	public List<Lieu> recupererLaListeDesBarsEnAttente() {
		return proxyDao.getAllBarsEnAttente();
	}

	@Override
	public List<Tournee> recupererLaListeDeToutesLesTournnesAVenir() {
		return proxyDao.getAllTourneesAVenir();
	}

}
