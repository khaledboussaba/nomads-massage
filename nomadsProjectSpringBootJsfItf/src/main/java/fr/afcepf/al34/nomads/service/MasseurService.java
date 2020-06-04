package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Masseur;

public interface MasseurService {
	boolean registerUser(Masseur utilisateur);
	
	/*
	 * @author: Khaled
	 */
	List<Masseur> recupererTousLesMasseur();

	Masseur recupererLeMasseur(Long id);

	Masseur mettreAjourMasseur(Masseur masseur);
}
