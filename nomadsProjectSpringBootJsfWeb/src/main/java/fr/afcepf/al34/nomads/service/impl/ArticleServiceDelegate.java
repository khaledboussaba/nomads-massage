package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.service.ArticleService;
import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;

@Service
public class ArticleServiceDelegate implements ArticleService {

	@Value(value = "${stock-api.base-url}")
	protected String baseStockUrl;
	
	private RestTemplate restTemplate = new RestTemplate();
	
	ObjectMapper jsonMapper = new ObjectMapper();
	
	@Override
	public List<Article> getAllArticles() {
		Object tmp = restTemplate.getForObject(baseStockUrl+"/stock-api/public/article/", List.class);
		JavaType type = jsonMapper.getTypeFactory().
				  constructCollectionType(List.class, Article.class);
		List<Article> articles = jsonMapper.convertValue(tmp, type);
		return articles;
	}

	@Override
	public List<Article> getArticlesByCategorie(Categorie categorie) {
		Object tmp = restTemplate.postForObject(baseStockUrl+"/stock-api/public/article/artcilesbycategorie",categorie, List.class);
		JavaType type = jsonMapper.getTypeFactory().
				  constructCollectionType(List.class, Article.class);
		List<Article> articles = jsonMapper.convertValue(tmp, type);
		return articles;
	}

	@Override
	public Article updateArticle(Article article) {
		Object tmp = restTemplate.postForObject(baseStockUrl+"/stock-api/public/article/updateArticle", article, Article.class);
		Article article1 = jsonMapper.convertValue(tmp,Article.class);
		return article1;
	}

	@Override
	public void deleteArticle(Long idArticle) {
		restTemplate.delete((baseStockUrl+"/stock-api/public/article/"+idArticle));
	}
	
}
