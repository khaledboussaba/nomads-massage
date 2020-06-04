package fr.afcepf.al34.AnnuaireMasseur.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Setter @Getter @NoArgsConstructor
public class Titre implements Serializable{



    /**
	 * 
	 */
	private static final long serialVersionUID = 1510252219947408325L;

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_titre")
    private Long id;

    /**
     * 
     */
    private String libelle;

}