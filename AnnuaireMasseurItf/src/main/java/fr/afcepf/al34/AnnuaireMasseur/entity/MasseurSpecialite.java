package fr.afcepf.al34.AnnuaireMasseur.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * 
 */
@Entity
@Table 
@Setter @Getter @NoArgsConstructor
public class MasseurSpecialite implements Serializable{


    /**
	 * 
	 */
	private static final long serialVersionUID = -2416783376267968963L;

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     */
    private Long idMasseur;

    /**
     * 
     */
    private Long idSpecialite;



}