package fr.afcepf.al34.nomads.dto;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import fr.afcepf.al34.nomads.entities.Commande;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CommandeDto {
	private Long masseurId;
	private Date date;
	private List<LigneCommandeDto> lignes;
	private Long idCommande;
}
