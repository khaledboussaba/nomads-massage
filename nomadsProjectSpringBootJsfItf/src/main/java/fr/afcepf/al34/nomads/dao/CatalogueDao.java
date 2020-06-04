package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface CatalogueDao extends GenericDao<Produit> {

	List<Tournee> getAllTournees();

	List<PackCredit> getAllPacks();

	List<Produit> getAllProducts();

	List<Materiel> getAllMateriels();

	Produit getProduitById(int i);



}
