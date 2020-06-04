package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade;
import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.AdministrateurService;
import fr.afcepf.al34.nomads.service.CommanditaireService;
import fr.afcepf.al34.nomads.service.LoginService;
import fr.afcepf.al34.nomads.service.MasseurService;
import fr.afcepf.al34.nomads.service.ServiceFacade;
import fr.afcepf.al34.nomads.ws.rest.service.impl.authenticator.AuthenticationManagerRest;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter @Setter
public class ServiceFacadeImpl implements ServiceFacade {
	
	
	@Autowired
	@Qualifier("masseurServiceImpl")
	private MasseurService masseurService;
	@Autowired
	@Qualifier("commanditaireServiceImpl")
	private CommanditaireService commanditaireService;
	@Autowired
	@Qualifier("administrateurServiceImpl")
	private AdministrateurService administrateurService;
	@Autowired
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	@Autowired
	private AuthenticationManagerRest authenticationManager;

	@Override
	public Utilisateur getUser() {
		Utilisateur user = null;
		if (loginService.isConnected()) {
			//user=(UtilisateurService<T>) getService(userType).getUser();
		}
		return user;
	}
	
	public <T> T getService(TypeUtilisateur userType) {
		T Service = null;
			switch (userType) {
			case ADMINISTRATEUR:
				Service = (T) getMasseurService();
				break;
			case COMMANDITAIRE:
				Service = (T) getCommanditaireService();
				break;
			case MASSEUR:
				Service = (T) getAdministrateurService();
				break;
			case UTILISATEUR:
			default:
				Service = null;
				break;
			}

		return Service;
	}

	@Override
	public List<Utilisateur> getUsers(TypeUtilisateur userType) {
		Object Service = getService(userType);
		
		return null;
	}

	
	
	@Override
	public String connexionUtilisateur() {
		String destination = "failure";
		loginService.setConnected(false);
		
		//TODO in login Service
		boolean success = false;
		//loginService.getUserByLogin();
		
		if (success) {
			loginService.setConnected(true);
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
