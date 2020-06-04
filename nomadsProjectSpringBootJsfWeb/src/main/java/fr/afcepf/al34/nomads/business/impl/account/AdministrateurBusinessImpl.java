package fr.afcepf.al34.nomads.business.impl.account;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.AdministrateurBusiness;
import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.service.impl.account.AdministrateurServiceDelegateImpl;
@Service
public class AdministrateurBusinessImpl extends AdministrateurServiceDelegateImpl implements AdministrateurBusiness {

	@Autowired 
	private LoginBusiness loginBusiness;
	
	private Administrateur utilisateur;
	
	public Administrateur getUser() {
		if(utilisateur==null) {
			utilisateur=(Administrateur) loginBusiness.getUtilisateur();
		}
		return utilisateur;
	}

	public Administrateur saveOrModifyUser(Administrateur utilisateur) {
		utilisateur = super.saveOrModifyUser(utilisateur);
		this.utilisateur=utilisateur;
		return utilisateur;
	}

	public List<Administrateur> getAllUsers(TypeUtilisateur type) {
		return super.getAllUsers(type);
	}

	public boolean registerUser(Administrateur utilisateur) {
		boolean success=super.registerUser(utilisateur);
		this.utilisateur=utilisateur;
		return success;
	}
	
}