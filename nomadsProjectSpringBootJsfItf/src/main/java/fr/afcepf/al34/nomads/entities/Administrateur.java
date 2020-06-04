package fr.afcepf.al34.nomads.entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@DiscriminatorValue(value="ADMINISTATEUR")
@Getter @Setter @NoArgsConstructor
public class Administrateur extends Utilisateur {
    
	private static final long serialVersionUID = -8992944729102295244L;

}
