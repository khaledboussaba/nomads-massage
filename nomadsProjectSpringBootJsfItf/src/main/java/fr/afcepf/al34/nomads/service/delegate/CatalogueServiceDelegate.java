package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface CatalogueServiceDelegate {

	
	List<Produit> afficherTousProduits();
	
	List<PackCredit> affichertousPacks();

	List<Tournee> afficherTousTournees();

	List<Materiel> afficheTousMateriels();

	Produit recupererParIdProduit(int i);

}