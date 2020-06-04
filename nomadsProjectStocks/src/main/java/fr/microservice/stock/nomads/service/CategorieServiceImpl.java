package fr.microservice.stock.nomads.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.microservice.stock.nomads.dao.CategorieDao;
import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.exception.MyEntityNotFoundException;

@Service
@Transactional
public class CategorieServiceImpl implements CategorieService {

	@Autowired
	private CategorieDao categorieDao;
	
	@Override
	public List<Categorie> rechercherToutesLesCategories() {
		return (List<Categorie>) categorieDao.findAll();
	}

	@Override
	public Categorie rechercherCategorieParId(Long idCategorie) {
		return categorieDao.findById(idCategorie).orElse(null);
	}

	@Override
	public Categorie savaugarderCategorie(Categorie categorie) {
		return categorieDao.save(categorie);
	}

	@Override
	public void supprimerCategorie(Long idCategorie) throws MyEntityNotFoundException {
		try {
			categorieDao.deleteById(idCategorie);
		} catch (Exception e) {
			throw new MyEntityNotFoundException("Echec de suppression avec ID : " + idCategorie + " !", e);
		}
	}

}
