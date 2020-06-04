package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al34.nomads.service.ArticleService;
import fr.afcepf.al34.nomads.service.CategorieService;
import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;

@ManagedBean("mbStock")
public class StockManagedBean implements Serializable {
	private static final long serialVersionUID = 5327407562944411731L;

	@Autowired
	private ArticleService articleService;

	@Autowired
	private CategorieService categorieService;

	private List<Article> articles;

	private List<Article> tables;
	private List<Article> chaises;
	private List<Article> huiles;
	private List<Article> accessoires;
	private List<Article> bonsCadeaux;

	private Categorie categorieTable;
	private Categorie categorieChaise;
	private Categorie categorieHuile;
	private Categorie categorieAccessoires;
	private Categorie categorieCadeau;

	private Article articleSelected;

	private String hideDivUpdate = "none";

	public StockManagedBean() {
	}

	@PostConstruct
	public void init() {
		hideDivUpdate = "none";
		try {
			articles = articleService.getAllArticles();
			categorieTable = categorieService.getCategorieById(1l);
			categorieChaise = categorieService.getCategorieById(2l);
			categorieHuile = categorieService.getCategorieById(3l);
			categorieAccessoires = categorieService.getCategorieById(4l);
			categorieCadeau = categorieService.getCategorieById(5l);
			tables = articleService.getArticlesByCategorie(categorieTable);
			chaises = articleService.getArticlesByCategorie(categorieChaise);
			huiles = articleService.getArticlesByCategorie(categorieHuile);
			accessoires = articleService.getArticlesByCategorie(categorieAccessoires);
			bonsCadeaux = articleService.getArticlesByCategorie(categorieCadeau);
		} catch (Exception e) {
			articles = new ArrayList<Article>();
			categorieTable = new Categorie();
			categorieChaise = new Categorie();
			categorieHuile = new Categorie();
			categorieAccessoires = new Categorie();
			categorieCadeau = new Categorie();
			tables = new ArrayList<Article>();
			chaises = new ArrayList<Article>();
			huiles = new ArrayList<Article>();
			accessoires = new ArrayList<Article>();
			bonsCadeaux = new ArrayList<Article>();
		}

		articleSelected = new Article();
	}

	public void selectArtcile(Article article) {
		hideDivUpdate = "block";
		articleSelected = article;
	}

	public void updateArticle() {
		System.out.println("++++++++++++++++++++++++" + articleSelected.getDesignation());
		System.out.println("++++++++++++++++++++++++" + articleSelected.getQuantite());
		articleSelected = articleService.updateArticle(articleSelected);
		hideDivUpdate = "none";
	}

	public void deleteArticle() {
		articleService.deleteArticle(articleSelected.getIdArticle());
		init();
	}

	public void fermerDetails() {
		hideDivUpdate = "none";
	}

	public List<Article> getArticles() {
		return articles;
	}

	public void setArticles(List<Article> articles) {
		this.articles = articles;
	}

	public List<Article> getTables() {
		return tables;
	}

	public void setTables(List<Article> tables) {
		this.tables = tables;
	}

	public List<Article> getChaises() {
		return chaises;
	}

	public void setChaises(List<Article> chaises) {
		this.chaises = chaises;
	}

	public List<Article> getHuiles() {
		return huiles;
	}

	public void setHuiles(List<Article> huiles) {
		this.huiles = huiles;
	}

	public List<Article> getAccessoires() {
		return accessoires;
	}

	public void setAccessoires(List<Article> accessoires) {
		this.accessoires = accessoires;
	}

	public List<Article> getBonsCadeaux() {
		return bonsCadeaux;
	}

	public void setBonsCadeaux(List<Article> bonsCadeaux) {
		this.bonsCadeaux = bonsCadeaux;
	}

	public Article getArticleSelected() {
		return articleSelected;
	}

	public void setArticleSelected(Article articleSelected) {
		this.articleSelected = articleSelected;
	}

	public String getHideDivUpdate() {
		return hideDivUpdate;
	}

	public void setHideDivUpdate(String hideDivUpdate) {
		this.hideDivUpdate = hideDivUpdate;
	}

}
