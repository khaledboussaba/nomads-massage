package fr.microservice.stock.nomadsProjectStocks;


import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.microservice.stock.nomads.GestionStocksApplication;
import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.service.ArticleService;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GestionStocksApplication.class})
public class ArticleTest {

	@Autowired
	private ArticleService articleService;
	
	@Test
	public void testSauvegarderArticle() {
		System.out.println(articleService);
		List<Article> articles = articleService.rechercherTousLesArticles();
		int size1 = articles.size();
		Article articleDeTest = new Article("article de test", 100.00, 20.00, 120.00, 5, "articleDeTest.png");
		articleService.savaugarderArticle(articleDeTest);
		List<Article> articles2 = articleService.rechercherTousLesArticles();
		int size2 = articles2.size();
		assertEquals(size2, size1 + 1);
	}

	@Test
	public void testRechercherTousLesArticles() {
		List<Article> articles = articleService.rechercherTousLesArticles();
		assertEquals(articles.size(), 30);
	}
	
	@Test
	public void testRchercherArticleParId() {
		Article articleDeTest = articleService.rechercherArticleParId(1L);
		assertEquals(articleDeTest.getIdArticle(), 1L, 0.0000001);
	}
	
	@Test
	public void testSupprimerArticle() {
		Article articleDeTest = articleService.rechercherArticleParId(31L);
		articleService.supprimerArticle(articleDeTest.getIdArticle());
		assertEquals(articleService.rechercherTousLesArticles().size(), 30);
	}

}
