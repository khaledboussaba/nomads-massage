package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "status_masseur")
@Getter @Setter @NoArgsConstructor
public class StatutMasseur extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = -8923156143282108770L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_status")
    private Long id;

    @Column(name = "libelle")
    private String libelle;
    
    @JsonIgnore
    @OneToMany(mappedBy = "statut")
    private List<Masseur> masseurs;

}
