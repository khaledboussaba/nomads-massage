package fr.afcepf.al34.nomads.entities;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="TOURNEE")
@Getter @Setter @NoArgsConstructor
public class Tournee extends Produit implements PayableCredit {

	private static final long serialVersionUID = -2447930421881633531L;


    @Temporal(TemporalType.DATE)
    @Column(name = "date")
    private Date date;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "heure_debut")
    private Date heureDebut;

    @Column(name = "heure_debut_imperative")
    private boolean heureDebutImperative;

    @Temporal(TemporalType.TIME)
    @JsonFormat(pattern = "HH:mm:ss")
    @Column(name = "heure_fin")
    private Date heureFin;

    @OneToMany(mappedBy = "tournee", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore
	private List<LieuTournee> lieuTournee;

    @Column(name = "tournee_imperative")
    private boolean tourneeImperative;
    
    @OneToMany(mappedBy = "tournee")
	@JsonIgnore
    private List<MasseurTournee> masseurTournees;

}
