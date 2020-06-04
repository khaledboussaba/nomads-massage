package fr.afcepf.al34.nomads.business.impl.account;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.impl.account.LoginServiceDelegateImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter @Setter @NoArgsConstructor
public class LoginBusinessImpl extends LoginServiceDelegateImpl implements LoginBusiness {

	private String login;
	private boolean connected=false;
	
	private String clearPassword;
	private TypeUtilisateur userType = TypeUtilisateur.UTILISATEUR;
	private Utilisateur utilisateur;
	
	@Override
	public boolean isUniqueLogin() {
		return super.isUniqueLogin(login);
	}
	
	@Override
	public boolean userNotExisting(String login) {
		this.login=login;
		return !isUniqueLogin();
	}

	@Override
	public synchronized boolean connexion() throws Exception { 

		return super.connexion();	
	}

	public Utilisateur getUserByLogin() {
		return super.getUserByLogin(login);
	}

	/*
	 * login from register page
	 */
	@Override
	public boolean userLogin(Utilisateur user) throws Exception {
		return userLogin(user.getCredentials());
	}
	
	/*
	 * Login from login page
	 */
	@Override
	public boolean userLogin(Credentials credentials) throws Exception {
		return super.userLogin(credentials);
	}

	@Override
	public Utilisateur getUserByCredentials(Credentials credentials) {
		
		
		utilisateur=super.getUserByCredentials(credentials);
		
		return utilisateur;
	}

}
