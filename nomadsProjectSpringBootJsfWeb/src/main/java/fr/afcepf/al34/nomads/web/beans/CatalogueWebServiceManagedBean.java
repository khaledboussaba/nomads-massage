package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CatalogueBusiness;
import fr.afcepf.al34.nomads.entities.ArticleFournisseur;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.service.ArticleService;
import fr.afcepf.al34.nomads.service.CategorieService;
import fr.microservice.stock.nomads.entities.Article;
import fr.microservice.stock.nomads.entities.Categorie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean("mbCatalogueWs")
@Getter
@Setter
@NoArgsConstructor
@SessionScope
public class CatalogueWebServiceManagedBean implements Serializable {
	private static final long serialVersionUID = -3677453447903433194L;

	@Autowired
	private ArticleService articleService;
	@Autowired
	private CategorieService categorieService;

	private List<Article> tousLesArticles;
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

	private String articlesAffihes;

	private Article articleSelected;
	private Produit produitSelected;

	private List<LigneCommande> lignesCommande = new ArrayList<LigneCommande>();

	private int nbArticle;

	@Autowired
	private CatalogueBusiness catalogueService;
	private List<PackCredit> packs;

	private String hideDivPacks = "none";
	private String hideDivArticles = "block";

	@PostConstruct
	public void init() {
		try {
			packs = catalogueService.affichertousPacks();
			tousLesArticles = articleService.getAllArticles();
			categorieTable = categorieService.getCategorieById(1L);
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
			packs = new ArrayList<PackCredit>();
			tousLesArticles = new ArrayList<Article>();
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
		articlesAffihes = "Tous les articles";
		hideDivPacks = "block";
	}

	public void getPacks() {
		articlesAffihes = "Packs disponibles";
		hideDivPacks = "block";
		hideDivArticles = "none";
	}

	public void getAllArticles() {
		tousLesArticles = articleService.getAllArticles();
		articlesAffihes = "Tous les articles";
		hideDivPacks = "block";
		hideDivArticles = "block";
	}

	public void getTables() {
		tousLesArticles = tables;
		articlesAffihes = "Tables disponibles";
		hideDivPacks = "none";
		hideDivArticles = "block";
	}

	public void getChaises() {
		tousLesArticles = chaises;
		articlesAffihes = "Chaises disponibles";
		hideDivPacks = "none";
		hideDivArticles = "block";
	}

	public void getHuiles() {
		tousLesArticles = huiles;
		articlesAffihes = "Huiles disponibles";
		hideDivPacks = "none";
		hideDivArticles = "block";
	}

	public void getAccessoires() {
		tousLesArticles = accessoires;
		articlesAffihes = "Accessoires disponibles";
		hideDivPacks = "none";
		hideDivArticles = "block";
	}

	public void getCadeaux() {
		tousLesArticles = bonsCadeaux;
		articlesAffihes = "Bons cadeaux disponibles";
		hideDivPacks = "none";
		hideDivArticles = "block";
	}

	public void ajouterPanier(Object article) {
		nbArticle++;
		Produit tmp = null;
		if (article instanceof Article) {

			articleSelected = (Article) article;

			tmp = new ArticleFournisseur(articleSelected.getIdArticle(), articleSelected.getDesignation(),
					articleSelected.getPrixUnitaireHT(), articleSelected.getTauxTva(),
					articleSelected.getPrixUnitaireTTC(), articleSelected.getPhoto());
		} else if (article instanceof Produit) {
			tmp = (Produit) article;
			produitSelected = tmp;
		}

		for (int i = 0; i < lignesCommande.size(); i++) {
			LigneCommande ligneCommandeParcourue = lignesCommande.get(i);
			if (ligneCommandeParcourue.getProduit().equals(tmp)) {
				ligneCommandeParcourue.setNbrProduit(ligneCommandeParcourue.getNbrProduit() + 1);
			}
		}
		LigneCommande nouvelleLigne = new LigneCommande();

		nouvelleLigne.setProduit(tmp);
		nouvelleLigne.setNbrProduit(1);
		lignesCommande.add(nouvelleLigne);
	}

	public int getQteArticlePanier() {
		int qteArticlePanier = 0;
		for (LigneCommande ligneCommande : lignesCommande) {
			qteArticlePanier += ligneCommande.getNbrProduit();
		}
		return qteArticlePanier;
	}

	public void supprPanier(LigneCommande ligneASupprimer) {
		lignesCommande.remove(ligneASupprimer);
	}

	public Double getTotalPrixPanier() {

		Double totalPrixPanier = 0D;
		for (LigneCommande ligneCommande : lignesCommande) {

			Double prixUnitaire = ligneCommande.getProduit().getPrixEuro();
			int qteProduit = ligneCommande.getNbrProduit();
			totalPrixPanier += prixUnitaire * qteProduit;
		}
		return totalPrixPanier;
	}

}
