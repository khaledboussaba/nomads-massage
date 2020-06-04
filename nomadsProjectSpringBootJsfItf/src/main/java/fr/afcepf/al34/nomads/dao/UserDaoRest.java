package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface UserDaoRest {
	List<Utilisateur> getAllUtilisateurs(TypeUtilisateur userType);
	Utilisateur sauvegarderUtilisateur(Utilisateur utilisateur);
	Utilisateur getUtilisateurById(Long idUtilisateur);
	boolean isUnique(String login);
	Utilisateur getUserByLogin(String login);
	Utilisateur getUserByCredentials(Credentials credentials);
	boolean userNotExisting(String login);
	String getSalt(String login);
	Credentials getCredentials(String login);
}
