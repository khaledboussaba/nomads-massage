package fr.afcepf.al34.nomads.dto;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class TournerDto {
	Tournee tournee;
	List<LieuTournee> lieuxTournees;
	LieuTournee lieuxTournee;
	Lieu lieuSelected;
	Long CommanditaireId;
	
	public TournerDto(Tournee tournee, Lieu lieuSelected, Long commanditaireId) {
		super();
		this.tournee = tournee;
		this.lieuSelected = lieuSelected;
		CommanditaireId = commanditaireId;
	}
	
	
	
}
