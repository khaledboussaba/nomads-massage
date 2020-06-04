package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface UtilisateurBusiness {
	Utilisateur getUser();
	Utilisateur saveOrModifyUser( Utilisateur utilisateur );
	List<Utilisateur> getAllUsers(TypeUtilisateur type);
	boolean registerUser(Utilisateur utilisateur) throws Exception;
}
