package fr.afcepf.al34.nomads.service;

import fr.afcepf.al34.nomads.entities.Administrateur;

public interface AdministrateurService {
	/**
	 * Author Sami
	 */
	boolean registerUser(Administrateur utilisateur) throws Exception;
}
