package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
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
@Table(name = "lieu")
@Getter @Setter @NoArgsConstructor
public class Lieu extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = 2685886903677267806L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_lieu")
    private Long id;

    @Column(name = "nom")
    private String nom;

    @ManyToOne
    @JoinColumn(name = "id_type")
    private Type type;
    
    @ManyToOne
    @JoinColumn(name = "id_commanditaire")
    private Commanditaire commanditaire;
    
    @Column(name = "actif")
    private boolean actif;
    
    @ManyToOne
    @JoinColumn(name = "id_status")
    public StatutLieu statut;

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "id_adresse")
    private Adresse adresse;

}
