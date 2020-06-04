package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;


public interface ArticleService {

	List<Article> getAllArticles();
	
	List<Article> getArticlesByCategorie(Categorie categorie);

	Article updateArticle(Article article);

	void deleteArticle(Long idArticle);
	
}
