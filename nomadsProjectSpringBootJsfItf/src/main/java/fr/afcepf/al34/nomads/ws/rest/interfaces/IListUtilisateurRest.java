package fr.afcepf.al34.nomads.ws.rest.interfaces;

import java.util.List;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.entities.Utilisateur;


public interface IListUtilisateurRest {
	public List<Utilisateur> getAllUsers(TypeUtilisateur typeUtilisateur);
}
