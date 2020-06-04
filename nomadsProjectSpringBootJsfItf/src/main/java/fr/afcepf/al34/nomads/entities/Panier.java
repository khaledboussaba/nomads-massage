package fr.afcepf.al34.nomads.entities;

import java.util.ArrayList;
import java.util.List;

import fr.afcepf.al34.nomads.entities.global.GenericEntity;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;



@Getter @Setter @NoArgsConstructor
public class Panier extends GenericEntity {
	
	private List<LigneCommande> lignes = new ArrayList<LigneCommande>();

	public void ajouteLigne(LigneCommande ligneAAjouter) {

		lignes.add(ligneAAjouter);

	}
	public void supprimeLigne(LigneCommande ligneASupprimer) {
		//lignes.remove();
	}

}
