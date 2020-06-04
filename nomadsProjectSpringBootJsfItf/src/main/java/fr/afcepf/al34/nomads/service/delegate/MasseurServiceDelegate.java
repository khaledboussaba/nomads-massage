package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Masseur;

public interface MasseurServiceDelegate {
	boolean registerUser(Masseur utilisateur);
	
	/*
	 * @author: Khaled
	 */
	List<Masseur> recupererTousLesMasseur();

	Masseur recupererLeMasseur(Long id);

	Masseur mettreAjourMasseur(Masseur masseur);
}
