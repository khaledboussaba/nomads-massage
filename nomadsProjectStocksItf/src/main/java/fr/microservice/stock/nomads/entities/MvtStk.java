package fr.microservice.stock.nomads.entities;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class MvtStk implements Serializable {
	private static final long serialVersionUID = 3887440107736341916L;

	public static final int ENTREE = 1;

	public static final int SORTIE = 2;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idMvtStk;

	@Temporal(TemporalType.TIMESTAMP)
	private Date dateMvt;

	private Integer quantite;

	private int typeMvt;

	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;

}
