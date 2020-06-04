package fr.afcepf.al34.nomads.dao;

import fr.afcepf.al34.nomads.entities.LigneCommande;

public interface LigneCommandeDao extends GenericDao<LigneCommande>{

	Long getNombreDeCreditAcrediter(Long id);

}
