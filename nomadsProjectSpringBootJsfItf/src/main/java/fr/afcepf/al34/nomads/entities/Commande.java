package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "commande")
@Getter @Setter @NoArgsConstructor
public class Commande extends GenericEntity implements InsertableIntoDatabase, Serializable{

	private static final long serialVersionUID = 1627573162186326394L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_commande")
	private Long id;

    @OneToMany(mappedBy = "commande")
    private List<LigneCommande> ligneCommandes;

    @ManyToOne
    @JoinColumn(name="id_masseur")
    private Masseur masseur;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

}
