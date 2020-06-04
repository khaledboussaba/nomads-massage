package fr.afcepf.al34.nomads.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import fr.afcepf.al34.nomads.entities.global.InsertableIntoDatabase;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "disponibilite")
@Getter @Setter @NoArgsConstructor
public class Disponibilite extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = -1146484560131088632L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_disponibilite")
	private Long id;

	@ManyToOne
	@JoinColumn(name = "id_utilisateur")
	private Utilisateur utilisateur;

	@Temporal(TemporalType.TIMESTAMP)
    @Column(name = "date")
    private Date date;

}
