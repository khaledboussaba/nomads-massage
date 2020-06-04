package fr.afcepf.al34.nomads.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="MASSEUR")
@Getter @Setter @NoArgsConstructor
public class Masseur extends Utilisateur {
    
	private static final long serialVersionUID = -6995026636664807594L;

	@Column(name = "nom_masseur")
	private String nomMasseur;

	@Column(name = "prenom_masseur")
	private String prenomMasseur;

	@Temporal(TemporalType.DATE)
	@Column(name = "date_naissance")
	private Date dateNaissance;

	@Column(name = "actif")
	private boolean actif;

	@Column(name = "porte_monnaie")
	private Long porteMonnaie;

	@OneToMany
	@JoinColumn(name = "id_masseur_tournees")
	public List<MasseurTournee> masseurTournee;

	@ManyToOne
	@JoinColumn(name = "id_status")
	private StatutMasseur statut;

	@OneToMany(mappedBy = "masseur", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<MasseurTournee> masseurTournees;

	@OneToMany(mappedBy = "masseur")
	@JsonIgnore
	private List<Commande> commandes;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "utilisateur")
	public List<Disponibilite> disponibilite;

}
