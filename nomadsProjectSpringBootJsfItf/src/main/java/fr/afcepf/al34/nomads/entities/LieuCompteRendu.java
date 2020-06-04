package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "lieu_compte_rendu")
@Getter @Setter @NoArgsConstructor
public class LieuCompteRendu extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = -6344736666850091555L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_lieu_compte_rendu")
	private Long id;

	@Column(name = "commentaire")
    private String commentaire;

}
