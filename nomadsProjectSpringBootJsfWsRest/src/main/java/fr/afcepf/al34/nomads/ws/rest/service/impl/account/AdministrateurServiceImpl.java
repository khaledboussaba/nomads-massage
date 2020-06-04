package fr.afcepf.al34.nomads.ws.rest.service.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dao.AdministrateurDao;
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.AdministrateurService;
import fr.afcepf.al34.nomads.service.LoginService;
import fr.afcepf.al34.nomads.ws.rest.service.impl.authenticator.AuthenticationManagerRest;
@Service
public class AdministrateurServiceImpl implements AdministrateurService {

	@Autowired
	protected  AdministrateurDao utilisateurDao;
	
	@Autowired 
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	
	private Administrateur utilisateur;
	
	public Administrateur getUser() {
		if(utilisateur==null) {
			utilisateur=(Administrateur) loginService.getUtilisateur();
		}
		return utilisateur;
	}

	public Administrateur saveOrModifyUser(Administrateur utilisateur) {
		utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
		return utilisateur;
	}

	public List<Administrateur> getAllUsers(TypeUtilisateur type) {
		if(!type.equals(TypeUtilisateur.MASSEUR)) {
			//TODO login error
			return new ArrayList<Administrateur>();
		}
		return (List<Administrateur>) utilisateurDao.getAllUtilisateurs();
	}

	public boolean registerUser(Administrateur utilisateur) {
		boolean success=false;
		if(loginService.userNotExisting(utilisateur.getCredentials().getLogin())){
			success=true;
			try {
				AuthenticationManagerRest.initialiseCredentials(utilisateur.getCredentials().getClearPassword(), utilisateur.getCredentials());
			} catch (Exception e1) {
				System.out.println("Probleme de generation de hash : "+e1.getMessage());
				return false;
			}
			utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
			if(utilisateur==null || ((Utilisateur)utilisateur).getId()==null) {
				success=false;
			}
		}else {
			System.out.println(utilisateur.getCredentials().getLogin()+" is in database");
		}
		return success;
	}
	
}