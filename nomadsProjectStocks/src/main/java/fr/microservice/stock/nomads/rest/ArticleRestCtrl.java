package fr.microservice.stock.nomads.rest;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.microservice.stock.nomads.dto.ResDelete;
import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.service.ArticleService;

@RestController
@RequestMapping(value = "/stock-api/public/article", headers = "Accept=application/json")
public class ArticleRestCtrl {
	
	@Autowired
	private ArticleService articleService;
	
	@RequestMapping(value = "", method = RequestMethod.GET)
	public List<Article> rechercherTousLesArticles(){
		return articleService.rechercherTousLesArticles();
	}
	
	@RequestMapping(value = "/{idArticle}", method = RequestMethod.GET)
	public Article getArticleById(@PathVariable("idArticle") Long id) {
		return articleService.rechercherArticleParId(id);
	}
	
	@PostMapping("/updateArticle")
	public Article updateArticle(@Valid @RequestBody Article article) {
		return articleService.savaugarderArticle(article);
	}
	
//	@PutMapping
//	public void updateArticle(@RequestBody Article article) {
//		articleService.savaugarderArticle(article);
//	}
	
	@DeleteMapping(value = "/{idArticle}")
	public ResponseEntity<ResDelete> deleteArticle(@PathVariable("idArticle") Long id) {
		try {
			articleService.supprimerArticle(id);
			return new ResponseEntity<ResDelete>(new ResDelete("suppression bien effectuée"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResDelete>(new ResDelete("devise déja supprimée ou inexistante"), HttpStatus.OK);
		}
	}

	
	@PostMapping(value = "/artcilesbycategorie")
	public List<Article> rechercherLesArticlesParCategorie(@RequestBody Categorie categorie){
		return articleService.rechercherLesArticlesParCategorie(categorie);
	}
	
}
