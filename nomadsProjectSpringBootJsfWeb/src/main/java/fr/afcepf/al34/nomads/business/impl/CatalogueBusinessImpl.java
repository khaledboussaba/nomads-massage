package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.CatalogueBusiness;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.impl.CatalogueServiceDelegateImpl;

@Service
public class CatalogueBusinessImpl extends CatalogueServiceDelegateImpl implements CatalogueBusiness {
	
	@Override
	public List<Produit> afficherTousProduits() {
		return super.afficherTousProduits();
	}
	

	@Override
	public List<PackCredit> affichertousPacks() {
		return super.affichertousPacks();
	}

	@Override
	public List<Tournee> afficherTousTournees() {
		return super.afficherTousTournees();
	}

	@Override
	public List<Materiel> afficheTousMateriels() {
		return super.afficheTousMateriels();
	}


	@Override
	public Produit recupererParIdProduit(int i) {
		return super.recupererParIdProduit(i);
	}

}
