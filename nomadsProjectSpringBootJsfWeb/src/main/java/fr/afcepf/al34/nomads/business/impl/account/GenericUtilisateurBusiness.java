package fr.afcepf.al34.nomads.business.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al34.nomads.business.BusinessFacade;
import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.business.UtilisateurBusiness;
import fr.afcepf.al34.nomads.dao.UtilisateurDao;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.impl.account.GenericUtilisateurServiceDelegateImpl;

public abstract class GenericUtilisateurBusiness extends GenericUtilisateurServiceDelegateImpl implements UtilisateurBusiness {
	
	private Utilisateur utilisateur;
	
	@Override
	public Utilisateur getUser() {
		return utilisateur;
	}

	@Override
	public Utilisateur saveOrModifyUser(Utilisateur utilisateur) {
		utilisateur = super.saveOrModifyUser(utilisateur);
		this.utilisateur=utilisateur;
		return utilisateur;
	}

	@Override
	public List<Utilisateur> getAllUsers(TypeUtilisateur type) {
		
		return super.getAllUsers(type);
	}

	@Override 
	public boolean registerUser(Utilisateur utilisateur) throws Exception {
		boolean success=super.registerUser(utilisateur);
		this.utilisateur=utilisateur;
		return success;
	}

}
