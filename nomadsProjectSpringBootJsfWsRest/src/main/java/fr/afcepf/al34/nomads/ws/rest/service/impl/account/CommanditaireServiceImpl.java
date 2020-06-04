package fr.afcepf.al34.nomads.ws.rest.service.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dao.CommanditaireDao;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.CommanditaireService;
import fr.afcepf.al34.nomads.service.LoginService;
import fr.afcepf.al34.nomads.ws.rest.service.impl.authenticator.AuthenticationManagerRest;
@Service
public class CommanditaireServiceImpl implements CommanditaireService{

	@Autowired
	protected  CommanditaireDao utilisateurDao;
	
	@Autowired 
	@Qualifier("loginServiceImpl")
	private LoginService loginService;
	
	private Commanditaire utilisateur;
	private String error="";
	public Commanditaire getUser() {
		return utilisateur;
	}

	public Commanditaire saveOrModifyUser(Commanditaire utilisateur) {
		utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
		return utilisateur;
	}

	public List<Masseur> getAllUsers(TypeUtilisateur type) {
		if(type!=TypeUtilisateur.MASSEUR) {
			//TODO login error
			return new ArrayList<Masseur>();
		}
		return (List<Masseur>) utilisateurDao.getAllUtilisateurs();
	}

	public boolean registerUser(Commanditaire utilisateur) {
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
			}else {
				try {
					success=loginService.userLogin(utilisateur);
					this.utilisateur=utilisateur;
				} catch (Exception e) {
					success=false;
					if(e.getMessage()==null) {
						e.printStackTrace();
					}
					System.out.println(e.getMessage());
				}
			}
		}else {
			System.out.println(utilisateur.getCredentials().getLogin()+" is in database");
		}
		return success;
	}

	/* 
	 * @Author : Khaled
	 */
	@Override
	public List<Commanditaire> recupererTousLesCommanditaires() {
		return utilisateurDao.getAllCommanditaires();
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	@Override
	public Commanditaire recupererCommanditaire(Long id) {
		return utilisateurDao.getUtilisateurById(id);
	}
	
}