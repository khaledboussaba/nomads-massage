package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface BusinessFacade {
	
	static public enum TypeUtilisateur {UTILISATEUR, MASSEUR,COMMANDITAIRE,ADMINISTRATEUR};
	
	public Utilisateur getUser();
	public List<Utilisateur> getUsers(TypeUtilisateur userType);
	public String connexionUtilisateur();
	public List<Tournee> getTournees(String action);
	public boolean registerUser(TypeUtilisateur userType);
}
