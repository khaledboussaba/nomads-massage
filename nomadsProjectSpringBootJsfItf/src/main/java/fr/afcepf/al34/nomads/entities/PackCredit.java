package fr.afcepf.al34.nomads.entities;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="PACK_CREDIT")
@Getter @Setter @NoArgsConstructor
public class PackCredit extends Produit implements PayableEuro {
	
	private static final long serialVersionUID = 4767127823248837339L;

    private String libelle;

    @Column(name = "nombre_credit")
    private Long nombreCredit;

}
