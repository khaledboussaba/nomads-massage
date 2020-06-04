package fr.microservice.stock.nomads.service;

import java.util.List;

import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.exception.MyEntityNotFoundException;

public interface ArticleService {
	
	List<Article> rechercherTousLesArticles();
	Article rechercherArticleParId(Long idArticle);
	Article savaugarderArticle(Article article);
	void supprimerArticle(Long idArticle) throws MyEntityNotFoundException;
	
	List<Article> rechercherLesArticlesParCategorie(Categorie categorie);

}
