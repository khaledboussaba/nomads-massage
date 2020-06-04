package fr.afcepf.al34.nomads.business;

import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface LoginBusiness {
	boolean isUniqueLogin();
	boolean connexion() throws Exception;
	
	Utilisateur getUserByLogin();

	String getLogin() ;

	void setLogin(String login) ;

	boolean isConnected();

	void setConnected(boolean isConnected);

	Utilisateur getUtilisateur() ;

	void setUtilisateur(Utilisateur utilisateur);
	
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
