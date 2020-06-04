package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CatalogueBusiness;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean("mbCatalogue")
@Getter @Setter @NoArgsConstructor 
@SessionScope
public class CatalogueManagedBean implements Serializable {
	/**
	* 
	*/
	private static final long serialVersionUID = 2451925568974048657L;

	@Autowired
	private CatalogueBusiness catalogueService;

//	private PanierBusiness panierBusiness;

	private List<Produit> produits;

	private List<PackCredit> packs;

	private List<Tournee> tournees;

	private List<Materiel> materiels;

	private List<LigneCommande> lignes = new ArrayList<LigneCommande>();

	public List<LigneCommande> getLignes() {
		return lignes;
	}

	private LigneCommande ligneCommandeAjoutee = new LigneCommande();

	// pour test
	// private int qteProduitPanier;
	private int nbArticlePourTest;
	private int idProduitAChercher;
	private Produit produitChoisi;
	// fin test

	@PostConstruct
	public void init() {

		//produits = catalogueService.afficherTousProduits();
		produits=new ArrayList<Produit>();
		packs = catalogueService.affichertousPacks();
		tournees = catalogueService.afficherTousTournees();
		materiels = catalogueService.afficheTousMateriels();
		
		for(Produit p:packs) {
			produits.add(p);
		}
		for(Produit p:tournees) {
			produits.add(p);
		}
		for(Produit p:materiels) {
			produits.add(p);
		}

	}

	// ajouter un article au panier
	public PackCredit getPackById(int i) {

		PackCredit pack = (PackCredit) catalogueService.recupererParIdProduit(i);
		return pack;
	}

	// TODO public String ajouterPanier(ActionEvent e) { // pour un action listener
	public String ajouterPanier(Produit produitChoisi) {

		//System.out.println("produitChoisi=" + produitChoisi);

		nbArticlePourTest++;
		this.produitChoisi = produitChoisi;
		// verifier si le produit est déjà dans le panier
		for (int i = 0; i < lignes.size(); i++) {
			LigneCommande ligneCommandeParcourue = lignes.get(i);
			if (ligneCommandeParcourue.getProduit().equals(produitChoisi)) {
				// si déjà dans panier ajouter +1
				ligneCommandeParcourue.setNbrProduit(ligneCommandeParcourue.getNbrProduit() + 1);
				return null;
			}
		}

		LigneCommande nouvelleLigne = new LigneCommande();
		nouvelleLigne.setProduit((PackCredit) produitChoisi);
		nouvelleLigne.setNbrProduit(1);
		lignes.add(nouvelleLigne);

		// calculerQteProduitPanier();

		// ne fonctionne pas pour la création de ligneCommande) pourquoi?
		/*
		 * ligneCommandeAjoutee.setProduit(p);
		 * ligneCommandeAjoutee.setNbrProduit(ligneCommandeAjoutee.getNbrProduit()+1);
		 * lignes.add(ligneCommandeAjoutee);
		 */

		return null; // à supprimer si Action listener

	}

	// TODO public String ajouterPanier(ActionEvent e) { // pour un action listener
	public String supprPanier(LigneCommande ligneASupprimer) {

		lignes.remove(ligneASupprimer);

		return null; // à supprimer si Action listener

	}

	public int getQteProduitPanier() {
		// utilisable avec mbCatalogue.qteProduitPanier sans "get" donc
		int qteProduitPanier = 0;
		for (LigneCommande ligneCommande : lignes) {
			qteProduitPanier += ligneCommande.getNbrProduit();
		}
		return qteProduitPanier;
	}

	public Double getTotalPrixPanier() {

		Double totalPrixPanier = 0D;
		for (LigneCommande ligneCommande : lignes) {

			Double prixUnitaire = ligneCommande.getProduit().getPrixEuro();
			int qteProduit = ligneCommande.getNbrProduit();
			totalPrixPanier += prixUnitaire * qteProduit;
		}
		return totalPrixPanier;
	}

	/*
	 * alternative private int qteProduitPanier ;
	 * 
	 * public void QteProduitPanier() { // utilisable avec
	 * mbCatalogue.qteProduitPanier sans "get" donc int qteProduitPanier = 0; for
	 * (LigneCommande ligneCommande : lignes) { qteProduitPanier +=
	 * ligneCommande.getNbrProduit(); } }
	 * 
	 * public String changerQuantite(LigneCommande LigneQteAModifier) { // trouver
	 * la lignecommande qui a le même article mb System.out.println("hello change");
	 * // trouver la qté for (int i = 0; i < lignes.size(); i++) { LigneCommande
	 * ligneCommandeParcourue = lignes.get(i); if
	 * (ligneCommandeParcourue.equals(LigneQteAModifier)) {
	 * 
	 * ligneCommandeParcourue.setNbrProduit(LigneQteAModifier.getNbrProduit()); }
	 * 
	 * getQteProduitPanier(); getTotalPrixPanier(); } return null; }
	 */
	public String allerAuPanier() {
		System.out.println("je vais au panier");
		return "goShoppingBasket";
	}

	public String allerAuCatalogue() {
		System.out.println("je vais au catalogue");
		return "catalogue";
	}

	public String panierString() {

		int nbrsProduits = getQteProduitPanier();
		if (nbrsProduits > 0)
			return "Panier(" + nbrsProduits + ")";

		return "Panier(vide)";
	}

}