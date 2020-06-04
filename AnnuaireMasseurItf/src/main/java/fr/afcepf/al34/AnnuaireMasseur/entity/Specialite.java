package fr.afcepf.al34.AnnuaireMasseur.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
public class Specialite implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = 5951803921723985978L;

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    /**
     * 
     */
    private String libelle;
    
    /**
     * 
     */
    @OneToMany (mappedBy="idSpecialite")
    @Column(name = "pratiquant")
    private List<MasseurSpecialite> lesSpecialistes;
    
    
    
    


}