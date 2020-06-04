package fr.afcepf.al34.nomads.business.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade;
import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.business.impl.authenticator.AuthenticationManager;
import fr.afcepf.al34.nomads.business.CommanditaireBusiness;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.dao.CommanditaireDao;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.impl.account.CommanditaireServiceDelegateImpl;
@Service
public class CommanditaireBusinessImpl extends CommanditaireServiceDelegateImpl implements CommanditaireBusiness{

	private Commanditaire utilisateur;
	private String error="";
	public Commanditaire getUser() {
		return utilisateur;
	}

	public Commanditaire saveOrModifyUser(Commanditaire utilisateur) {
		utilisateur = super.saveOrModifyUser(utilisateur);
		return utilisateur;
	}

	public List<Masseur> getAllUsers(TypeUtilisateur type) {
		
		return super.getAllUsers(type);
	}

	public Commanditaire registerUser(Commanditaire utilisateur) {
		this.utilisateur= super.registerUser(utilisateur);
		return this.utilisateur;
	}

	/* 
	 * @Author : Khaled
	 */
	@Override
	public List<Commanditaire> recupererTousLesCommanditaires() {
		return super.recupererTousLesCommanditaires();
	}

	public String getError() {
		return super.getError();
	}

	public void setError(String error) {
		this.error = error;
		super.setError(error);
	}

	@Override
	public Commanditaire recupererCommanditaire(Long id) {
		return super.recupererCommanditaire(id);
	}
	
}