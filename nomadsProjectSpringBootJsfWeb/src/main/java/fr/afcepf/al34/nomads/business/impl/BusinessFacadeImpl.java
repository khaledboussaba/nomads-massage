package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.AdministrateurBusiness;
import fr.afcepf.al34.nomads.business.BusinessFacade;
import fr.afcepf.al34.nomads.business.CommanditaireBusiness;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.business.MasseurBusiness;
import fr.afcepf.al34.nomads.business.impl.authenticator.AuthenticationManager;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter @Setter
public class BusinessFacadeImpl implements BusinessFacade {
	
	
	@Autowired
	private MasseurBusiness masseurBusiness;
	@Autowired
	private CommanditaireBusiness commanditaireBusiness;
	@Autowired
	private AdministrateurBusiness administrateurBusiness;
	@Autowired
	private LoginBusiness loginBusiness;
	@Autowired
	private AuthenticationManager authenticationManager;

	@Override
	public Utilisateur getUser() {
		Utilisateur user = null;
		if (loginBusiness.isConnected()) {
			//user=(UtilisateurBusiness<T>) getBusiness(userType).getUser();
		}
		return user;
	}
	
	public <T> T getBusiness(TypeUtilisateur userType) {
		T business = null;
			switch (userType) {
			case ADMINISTRATEUR:
				business = (T) getMasseurBusiness();
				break;
			case COMMANDITAIRE:
				business = (T) getCommanditaireBusiness();
				break;
			case MASSEUR:
				business = (T) getAdministrateurBusiness();
				break;
			case UTILISATEUR:
			default:
				business = null;
				break;
			}

		return business;
	}

	@Override
	public List<Utilisateur> getUsers(TypeUtilisateur userType) {
		Object business = getBusiness(userType);
		
		return null;
	}

	
	
	@Override
	public String connexionUtilisateur() {
		String destination = "failure";
		loginBusiness.setConnected(false);
		
		//TODO in login business
		boolean success = false;
		//loginBusiness.getUserByLogin();
		
		if (success) {
			loginBusiness.setConnected(true);
			destination = "success";
		}

		return destination;
	}

	@Override
	public List<Tournee> getTournees(String action) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean registerUser(TypeUtilisateur userType) {
		
		return false;
	}

}
