package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;
import java.util.LinkedHashMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.LigneCommandeDto;
import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "ligne_commande")
@Getter @Setter @NoArgsConstructor
public class LigneCommande extends GenericEntity implements InsertableIntoDatabase, Serializable {

	public LigneCommande(LigneCommandeDto ligneDto) {
		ObjectMapper jsonMapper = new ObjectMapper();
		
		id=ligneDto.getId();
		nbrProduit=ligneDto.getNbrProduit();
		System.out.println("SASASAAS="+ligneDto.getProduit());
		produit=(Produit) jsonMapper.convertValue(ligneDto.getProduit(), ligneDto.getProduitClass());
		System.out.println("SASASAAS produit="+produit);
		
		commande=ligneDto.getCommande();
	}

	private static final long serialVersionUID = 3684878105817499056L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ligne_commande")
    @JsonIgnore
    private Long id;

    @Column(name = "nombre_produit")
    private int nbrProduit;

    @OneToOne
    @JoinColumn(name = "id_produit")
    private Produit produit;
    
    @ManyToOne
    @JoinColumn(name ="id_commande")
    @JsonIgnore
    private Commande commande;

}
