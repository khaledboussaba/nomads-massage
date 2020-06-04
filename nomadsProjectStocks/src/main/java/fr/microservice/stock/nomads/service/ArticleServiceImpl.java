package fr.microservice.stock.nomads.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.microservice.stock.nomads.dao.ArticleDao;
import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.exception.MyEntityNotFoundException;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {

	@Autowired
	private ArticleDao articleDao;
	
	@Override
	public List<Article> rechercherTousLesArticles() {
		return (List<Article>) articleDao.findAll();
	}
	
	@Override
	public Article rechercherArticleParId(Long idArticle) {
		return articleDao.findById(idArticle).orElse(null);
	}
	
	@Override
	public Article savaugarderArticle(Article article) {
		return articleDao.save(article);
	}

	@Override
	public void supprimerArticle(Long idArticle) throws MyEntityNotFoundException {
		try {
			articleDao.deleteById(idArticle);			
		} catch (Exception e) {
			throw new MyEntityNotFoundException("Echec de suppression avec ID : " + idArticle + " !", e);
		}
	}

	@Override
	public List<Article> rechercherLesArticlesParCategorie(Categorie categorie) {
		return (List<Article>) articleDao.findByCategorie(categorie);
	}

}
