package fr.afcepf.al34.nomads.service;

import fr.afcepf.al34.nomads.entities.LigneCommande;

public interface LigneCommandeService {

	void enregisterLigneCommande(LigneCommande ligneCommande);

	Long recupererLeNombreDeCreditAcrediter(Long id);
	
	

}
