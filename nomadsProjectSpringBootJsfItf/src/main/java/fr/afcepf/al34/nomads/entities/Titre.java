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
@Table(name = "titre")
@Getter @Setter @NoArgsConstructor
public class Titre extends GenericEntity implements InsertableIntoDatabase, Serializable {

	private static final long serialVersionUID = 5124628748716346762L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_titre")
    private Long id;

    private String libelle;
    
    @OneToMany(mappedBy = "titre")
    @JsonIgnore
    private List<Contact> contacts;

	@Override
	public String toString() {
		return String.format("%s[id=%d]", getClass().getSimpleName(), getId());
		
	}

}
