package fr.microservice.stock.nomads.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Article implements Serializable {
	private static final long serialVersionUID = 6658570483994420044L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idArticle;
	
	private String designation;
	
	@Column(name = "prix_unitaire_ht")
	private Double prixUnitaireHT;
	
	private Double tauxTva;
	
	@Column(name = "prix_unitaire_ttc")
	private Double prixUnitaireTTC;
	
	private Integer quantite;
	
	private String photo;
	
	@ManyToOne
	@JoinColumn(name = "id_categorie")
	private Categorie categorie;

	public String getphoto;

	public Article(String designation, Double prixUnitaireHT, Double tauxTva,
			Double prixUnitaireTTC, Integer quantite, String photo) {
		this.designation = designation;
		this.prixUnitaireHT = prixUnitaireHT;
		this.tauxTva = tauxTva;
		this.prixUnitaireTTC = prixUnitaireTTC;
		this.quantite = quantite;
		this.photo = photo;
	}

}
