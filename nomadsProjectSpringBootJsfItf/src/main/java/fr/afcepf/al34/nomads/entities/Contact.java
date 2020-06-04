package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "contact")
@Getter @Setter @NoArgsConstructor
public class Contact  extends GenericEntity implements InsertableIntoDatabase, Serializable{

	private static final long serialVersionUID = -650670092900326871L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_contact")
    private Long id;

    @Column(name = "contact_nom")
    private String nom;

    @Column(name = "contact_prenom")
    private String prenom;

    @Column(name="numero_telephone")
    private String numeroTelephone;

    @Column(name = "email")
    private String email;

    @Column(name="fonction_niveau")
    private String posteOccupe;

    @ManyToOne
	@JoinColumn(name = "id_titre")
	private Titre titre;
    
    @ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

}
