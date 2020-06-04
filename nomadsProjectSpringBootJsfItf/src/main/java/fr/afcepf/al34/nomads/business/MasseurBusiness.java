package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.dto.CommandeDto;
import fr.afcepf.al34.nomads.dto.TournerBuyDto;
import fr.afcepf.al34.nomads.entities.Masseur;

public interface MasseurBusiness {
	boolean registerUser(Masseur utilisateur);
	
	/*
	 * @author: Khaled
	 */
	List<Masseur> recupererTousLesMasseur();

	Masseur recupererLeMasseur(Long id);

	Masseur mettreAjourMasseur(Masseur masseur);

	TournerBuyDto buyTournee(TournerBuyDto tbdto);

	CommandeDto enregistrerCommande(CommandeDto cdto);
}
