package fr.microservice.stock.nomads.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class LigneCommandeClient implements Serializable {
	private static final long serialVersionUID = 2699809934776626563L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idLigneCdeClt;
	
	@ManyToOne
	@JoinColumn(name = "id_article")
	private Article article;
	
	@ManyToOne
	@JoinColumn(name = "id_commande_client")
	private CommandeClient commandeClient;
	
}
