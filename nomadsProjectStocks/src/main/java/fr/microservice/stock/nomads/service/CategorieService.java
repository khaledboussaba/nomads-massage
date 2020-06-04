package fr.microservice.stock.nomads.service;

import java.util.List;

import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.exception.MyEntityNotFoundException;

public interface CategorieService {
	
	List<Categorie> rechercherToutesLesCategories();
	Categorie rechercherCategorieParId(Long idCategorie);
	Categorie savaugarderCategorie(Categorie categorie);
	void supprimerCategorie(Long idCategorie) throws MyEntityNotFoundException;

}
