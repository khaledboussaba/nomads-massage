package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="ArticleFournisseur")
@Getter @Setter @NoArgsConstructor
public class ArticleFournisseur extends Produit implements PayableCredit, PayableEuro, Serializable {

	private static final long serialVersionUID = 4931421729472023333L;

	@Column(name = "id_article_fournisseur")
	private Long idArticle;
	
	@Column(name = "id_fournisseur")
	private Long idFournisseur;
	
	private String designation;
	
	@Column(name = "prix_unitaire_ht")
	private Double prixUnitaireHT;
	
	private Double tauxTva;
	
	@Column(name = "prix_unitaire_ttc")
	private Double prixUnitaireTTC;
	
	
	private Integer quantite;
	
	private String photo;
	
	private String libelle;

	public ArticleFournisseur(Long idArticle, String designation, Double prixUnitaireHT,
			Double tauxTva, Double prixUnitaireTTC, String photo) {
		super();
		this.idArticle = idArticle;
//		this.idFournisseur = idFournisseur;
		this.designation = designation;
		this.prixUnitaireHT = prixUnitaireHT;
		this.tauxTva = tauxTva;
		this.prixUnitaireTTC = prixUnitaireTTC;
//		this.quantite = quantite;
		this.photo = photo;
		this.setPrixEuro(this.prixUnitaireTTC);
		this.setLibelle(this.designation);
	}
	
	
}
