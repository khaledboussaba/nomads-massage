package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="MATERIEL")
@Getter @Setter @NoArgsConstructor
public class Materiel extends Produit implements PayableCredit, PayableEuro, Serializable {

	private static final long serialVersionUID = -681834477418253509L;

    private String categorie;

    private String couleur;

    private String taille;
    
    private String marque;
    
    private String modele;
    
    private int quantite;

}
