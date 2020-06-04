package fr.afcepf.al34.nomads.business;

import fr.afcepf.al34.nomads.entities.LigneCommande;

public interface LigneCommandeBusiness {

	void enregisterLigneCommande(LigneCommande ligneCommande);

	Long recupererLeNombreDeCreditAcrediter(Long id);
	
	

}
