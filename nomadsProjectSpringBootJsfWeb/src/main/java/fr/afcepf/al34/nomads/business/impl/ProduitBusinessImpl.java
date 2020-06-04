package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.ProduitBusiness;
import fr.afcepf.al34.nomads.dao.ProduitDao;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.impl.ProduitServiceDelegateImpl;

@Service
public class ProduitBusinessImpl extends ProduitServiceDelegateImpl implements ProduitBusiness {
	
	@Override
	public List<Produit> recupererLaListeDesTshirt() {
		return super.recupererLaListeDesTshirt();
	}

	@Override
	public List<Produit> recupererLaListeDesPacks() {
		return super.recupererLaListeDesPacks();
	}

	@Override
	public Long recupererLeNombreDeTshirtDisponile() {
		return super.recupererLeNombreDeTshirtDisponile();
	}

	@Override
	public Long recupererLeNombreDeTPEdisponile() {
		return super.recupererLeNombreDeTPEdisponile();
	}

	@Override
	public Long recupererLeNombreFormulesPacks() {
		return super.recupererLeNombreFormulesPacks();
	}

	@Override
	public Long recupererLeNombreDeChaisesdisponile() {
		return super.recupererLeNombreDeChaisesdisponile();
	}

	@Override
	public List<Produit> recupererLaListeDesTPE() {
		return super.recupererLaListeDesTPE();
	}

	@Override
	public List<Produit> recupererLaListeDesChaises() {
		return super.recupererLaListeDesChaises();
	}

	@Override
	public Long recupererLeNombreDeBarActifs() {
		return super.recupererLeNombreDeBarActifs();
	}

	@Override
	public Long recupererLeNombreDeBarEnAttente() {
		return super.recupererLeNombreDeBarEnAttente();
	}

	@Override
	public Long recupererLeNombreDeBarInactifs() {
		return super.recupererLeNombreDeBarInactifs();
	}

	@Override
	public Long recupererLeNombreDeMasseursActifs() {
		return super.recupererLeNombreDeMasseursActifs();
	}

	@Override
	public Long recupererLeNombreDeMasseursInactifs() {
		return super.recupererLeNombreDeMasseursInactifs();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenir() {
		return super.recupererLeNombreDeTourneesAVenir();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtComplete() {
		return super.recupererLeNombreDeTourneesAVenirEtComplete();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtSemiComplete() {
		return super.recupererLeNombreDeTourneesAVenirEtSemiComplete();
	}

	@Override
	public Long recupererLeNombreDeTourneesAVenirEtVide() {
		return super.recupererLeNombreDeTourneesAVenirEtVide();
	}

	@Override
	public List<Lieu> recupererLaListeDesBarsEnAttente() {
		return super.recupererLaListeDesBarsEnAttente();
	}

	@Override
	public List<Tournee> recupererLaListeDeToutesLesTournnesAVenir() {
		return super.recupererLaListeDeToutesLesTournnesAVenir();
	}

}
