package fr.afcepf.al34.nomads.service.delegate;

import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface LoginServiceDelegate {

	boolean connexion() throws Exception ;
	 boolean isUniqueLogin(String login);
	Utilisateur getUserByLogin(String login);

	/**
	 * Author Sami
	 */
	boolean userNotExisting(String login);

	/**
	 * Author Sami
	 * @throws Exception 
	 */
	boolean userLogin(Utilisateur user) throws Exception;
	
	/**
	 * Author Sami
	 * @throws Exception 
	 */
	boolean userLogin(Credentials credentials) throws Exception;
	
	/**
	 * Author Sami 
	 */
	Utilisateur getUserByCredentials(Credentials credentials);
}
