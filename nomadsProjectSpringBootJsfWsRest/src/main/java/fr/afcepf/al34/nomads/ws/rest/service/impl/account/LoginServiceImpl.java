package fr.afcepf.al34.nomads.ws.rest.service.impl.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dao.CredentialsDao;
import fr.afcepf.al34.nomads.dao.UtilisateurDao;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.LoginService;
import fr.afcepf.al34.nomads.ws.rest.service.impl.authenticator.AuthenticationManagerRest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter @Setter @NoArgsConstructor
public class LoginServiceImpl implements LoginService {
	private String login;
	private boolean connected=false;
	
	private String clearPassword;
	private TypeUtilisateur userType = TypeUtilisateur.UTILISATEUR;
	private Utilisateur utilisateur;
	
	@Autowired
	private UtilisateurDao utilisateurDao; 
	
	@Autowired
	private CredentialsDao credentialsDao; 
	
	@Override
	public boolean isUniqueLogin() {
		return utilisateurDao.isUnique(login);
	}
	
	@Override
	public boolean userNotExisting(String login) {
		this.login=login;
		return !isUniqueLogin();
	}

	@Override
	public synchronized boolean connexion() throws Exception { 
		boolean success = AuthenticationManagerRest.authenticate(clearPassword, credentialsDao.getCredentialsByLogin(login));
		return success; 	
	}

	public Utilisateur getUserByLogin() {
		return utilisateurDao.getUserByLogin(login);
	}

	/*
	 * login from register page
	 */
	@Override
	public boolean userLogin(Utilisateur user) throws Exception {
		boolean success = userLogin(user.getCredentials());
		return success;
	}
	
	/*
	 * Login from login page
	 */
	@Override
	public boolean userLogin(Credentials credentials) throws Exception {
		boolean success = AuthenticationManagerRest.authenticate(credentials.getClearPassword(),credentials);
		return success;
	}

	@Override
	public Utilisateur getUserByCredentials(Credentials credentials) {
		boolean success=false;
		Credentials cred=utilisateurDao.getCredentials(credentials.getLogin());
		try {
			
			
			if(cred==null) {
				return null;
			}
				
			success=AuthenticationManagerRest.authenticate(credentials.getClearPassword(), cred);
			
//			System.out.println("success="+success);
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(success) {
			utilisateur=utilisateurDao.getUserByCredentials(cred);
		}else {
			utilisateur=null;
		}
		return utilisateur;
	}

}
