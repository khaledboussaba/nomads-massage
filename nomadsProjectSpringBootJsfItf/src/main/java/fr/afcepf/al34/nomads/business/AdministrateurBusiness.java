package fr.afcepf.al34.nomads.business;

import fr.afcepf.al34.nomads.entities.Administrateur;

public interface AdministrateurBusiness {
	/**
	 * Author Sami
	 */
	boolean registerUser(Administrateur utilisateur) throws Exception;
}
