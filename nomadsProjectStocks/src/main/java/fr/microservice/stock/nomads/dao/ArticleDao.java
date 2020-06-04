package fr.microservice.stock.nomads.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;



public interface ArticleDao extends CrudRepository<Article, Long> {
	
	List<Article> findByDesignation(String designation);
	List<Article> findByCategorie(Categorie categorie);
	
}