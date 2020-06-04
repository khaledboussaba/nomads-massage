package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "masseur_tournee")
@Getter @Setter @NoArgsConstructor
public class MasseurTournee extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = -3993915911634008312L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_masseur_tournee")
    private Long id;
    
    @ManyToOne
    @JoinColumn(name = "id_masseur")
	@JsonIgnore
    private Masseur masseur;
    
    @ManyToOne
    @JoinColumn(name = "id_tournee")
	private Tournee tournee;

    @OneToOne
    @JoinColumn(name = "id_masseur_compte_rendu")
    private MasseurCompteRendu masseurCompteRendu;

}
