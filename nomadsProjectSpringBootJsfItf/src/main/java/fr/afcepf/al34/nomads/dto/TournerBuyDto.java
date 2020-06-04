package fr.afcepf.al34.nomads.dto;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.entities.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TournerBuyDto {
	Tournee tournee;
	List<MasseurTournee> masseurTournees;
	Masseur masseur;
	
	public TournerBuyDto(Tournee tournee,List<MasseurTournee> masseursTournees,
			Masseur masseur) {
		super();
		this.tournee = tournee;
		this.masseurTournees = masseursTournees;
		this.masseur = masseur;
	}
	
}
