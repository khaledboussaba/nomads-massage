package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface UtilisateurService {
	Utilisateur getUser();
	Utilisateur saveOrModifyUser( Utilisateur utilisateur );
	List<Utilisateur> getAllUsers(TypeUtilisateur type);
	boolean registerUser(Utilisateur utilisateur) throws Exception;
}
