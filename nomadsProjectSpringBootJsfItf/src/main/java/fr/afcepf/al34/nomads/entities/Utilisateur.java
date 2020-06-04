package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlTransient;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utilisateur")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(
        name="id_discriminator_utilisateur",
        discriminatorType=DiscriminatorType.STRING
        )
@Getter @Setter @NoArgsConstructor
@XmlAccessorType(XmlAccessType.FIELD)
public class Utilisateur extends GenericEntity implements InsertableIntoDatabase, Serializable {
	
	private static final long serialVersionUID = 7191980307533364706L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private Long id;
    
    @Column(name = "raison_sociale")
    private String raisonSociale;

    @Column(name = "numero_siret")
    private String numeroSIRET;
    
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_credential")
    private Credentials credentials;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
    private List<Contact> contacts;
    
}
