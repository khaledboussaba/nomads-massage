package fr.afcepf.al34.AnnuaireMasseur.entity;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class Masseur implements Serializable {


    /**
	 * 
	 */
	private static final long serialVersionUID = -3104730242303782584L;

	/**
     * 
     */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name ="id_masseur")
    private Long id;

    /**
     * 
     */
    private String raisonSociale;

    /**
     * 
     */
    private String numeroSiret;

    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name = "id_titre")
    public Titre titre;
    /**
     * 
     */
    private String nom;

    /**
     * 
     */
    private String prenom;

    /**
     * 
     */
    private boolean actif;

    /**
     * 
     */
    private String email;

    /**
     * 
     */
    private String telephone;
    /**
     * 
     */
    //le MappedBy fait référence à l'attribut lié dans MasseurSpecialité)
    @OneToMany(mappedBy ="idMasseur") 
    @Column(name = "specialite")
    public Set<MasseurSpecialite> lesSpecialites;




}