package fr.afcepf.al34.nomads.service.delegate;

import fr.afcepf.al34.nomads.entities.LigneCommande;

public interface LigneCommandeServiceDelegate {

	void enregisterLigneCommande(LigneCommande ligneCommande);

	Long recupererLeNombreDeCreditAcrediter(Long id);
	
	

}
