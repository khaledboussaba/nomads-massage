package fr.microservice.stock.nomads.entities;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Client implements Serializable {
	private static final long serialVersionUID = 7264373710632274706L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idClient;
	
	private String nom;
	
	private String prenom;
	
	private String adresse;
	
	private String mail;
	
	private String photo;

	public Client(String nom, String prenom, String adresse, String mail, String photo) {
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.mail = mail;
		this.photo = photo;
	}
	
}
