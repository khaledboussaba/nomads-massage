package fr.afcepf.al34.nomads.service;

import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface LoginService {

	boolean connexion() throws Exception ;
	public boolean isUniqueLogin();
	Utilisateur getUserByLogin();

	boolean isConnected();
	void setConnected(boolean b);
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
	Utilisateur getUtilisateur();
}
