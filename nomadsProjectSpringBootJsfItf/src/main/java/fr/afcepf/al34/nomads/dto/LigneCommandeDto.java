package fr.afcepf.al34.nomads.dto;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class LigneCommandeDto implements Serializable {

	public LigneCommandeDto(LigneCommande ligne) {
		id=ligne.getId();
		nbrProduit=ligne.getNbrProduit();
		produitClass=ligne.getProduit().getClass();
		produit=ligne.getProduit();
		commande=ligne.getCommande();
	}

	private static final long serialVersionUID = 3684878105817499056L;
   
    private Long id;

    private int nbrProduit;

    private Class produitClass;
    
    private Object produit;
    
    private Commande commande;

}
