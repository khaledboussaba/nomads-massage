package fr.microservice.stock.nomads.entities;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter @Setter @NoArgsConstructor
public class Categorie implements Serializable {
	@JsonIgnore
	private static final long serialVersionUID = 6243854074681421061L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long idCategorie;
	
	private String designation;
	
	@OneToMany(mappedBy = "categorie")
	@JsonIgnore
	private List<Article> articles;

	public Categorie(String designation) {
		this.designation = designation;
	}
	
}
