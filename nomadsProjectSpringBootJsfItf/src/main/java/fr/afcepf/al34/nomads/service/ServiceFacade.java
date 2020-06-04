package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.business.BusinessFacade;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface ServiceFacade {
	
	
	
	public Utilisateur getUser();
	public List<Utilisateur> getUsers(BusinessFacade.TypeUtilisateur userType);
	public String connexionUtilisateur();
	public List<Tournee> getTournees(String action);
	public boolean registerUser(BusinessFacade.TypeUtilisateur userType);
}
