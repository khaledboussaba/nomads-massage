package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lieu_tournee")
@Getter @Setter @NoArgsConstructor
public class LieuTournee extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = -2121472220421171238L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lieu_tournee")
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "id_tournee")
    private Tournee tournee;

    @ManyToOne
    @JoinColumn(name = "id_lieu")
    private Lieu lieu;

    @OneToMany
    @JoinColumn(name = "id_lieu_compte_rendus")
    public List<LieuCompteRendu> lieuCompteRendus;

}
