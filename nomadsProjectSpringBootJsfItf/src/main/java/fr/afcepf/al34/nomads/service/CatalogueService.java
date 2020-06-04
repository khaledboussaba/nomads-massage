package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface CatalogueService {

	
	List<Produit> afficherTousProduits();
	
	List<PackCredit> affichertousPacks();

	List<Tournee> afficherTousTournees();

	List<Materiel> afficheTousMateriels();

	Produit recupererParIdProduit(int i);

}
