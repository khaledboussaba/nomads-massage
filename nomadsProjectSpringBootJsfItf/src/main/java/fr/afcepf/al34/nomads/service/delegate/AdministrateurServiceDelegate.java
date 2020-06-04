package fr.afcepf.al34.nomads.service.delegate;

import fr.afcepf.al34.nomads.entities.Administrateur;

public interface AdministrateurServiceDelegate {
	/**
	 * Author Sami
	 */
	boolean registerUser(Administrateur utilisateur) throws Exception;
}
