package fr.microservice.stock.nomads.dto;

import java.io.Serializable;

import fr.microservice.stock.nomads.entities.Categorie;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ArticleDto implements Serializable {
	private static final long serialVersionUID = 6658570483994420044L;

	private Long idArticle;
	private String designation;
	private Double prixUnitaireHT;
	private Double tauxTva;
	private Double prixUnitaireTTC;
	private Integer quantite;
	private String photo;
	private Categorie categorie;

	public ArticleDto(String designation, Double prixUnitaireHT, Double tauxTva,
			Double prixUnitaireTTC, Integer quantite, String photo) {
		this.designation = designation;
		this.prixUnitaireHT = prixUnitaireHT;
		this.tauxTva = tauxTva;
		this.prixUnitaireTTC = prixUnitaireTTC;
		this.quantite = quantite;
		this.photo = photo;
	}

}
