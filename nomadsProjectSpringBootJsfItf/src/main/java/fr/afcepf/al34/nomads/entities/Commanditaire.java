package fr.afcepf.al34.nomads.entities;

import java.util.List;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="COMMANDITAIRE")
@Getter @Setter @NoArgsConstructor
public class Commanditaire extends Utilisateur {
    
	private static final long serialVersionUID = -3457647394031260505L;

    @OneToMany(mappedBy = "commanditaire")
    @JsonIgnore
    private List<Lieu> lieux;

}
