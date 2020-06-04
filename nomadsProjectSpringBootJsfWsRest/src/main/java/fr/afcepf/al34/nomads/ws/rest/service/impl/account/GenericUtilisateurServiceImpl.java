package fr.afcepf.al34.nomads.ws.rest.service.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.dao.UtilisateurDao;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.UtilisateurService;

public abstract class GenericUtilisateurServiceImpl implements UtilisateurService {
	@Autowired
	private 
	UtilisateurDao utilisateurDao;
	
	@Autowired
	LoginBusiness loginBusiness;
	
	private Utilisateur utilisateur;
	
	@Override
	public Utilisateur getUser() {
		return utilisateur;
	}

	@Override
	public Utilisateur saveOrModifyUser(Utilisateur utilisateur) {
		utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
		return utilisateur;
	}

	@Override
	public List<Utilisateur> getAllUsers(TypeUtilisateur type) {
		if(type!=TypeUtilisateur.MASSEUR) {
			//TODO login error
			return new ArrayList<Utilisateur>();
		}
		return (List<Utilisateur>) utilisateurDao.getAllUtilisateurs();
	}

	@Override 
	public boolean registerUser(Utilisateur utilisateur) throws Exception {
		boolean success=false;
		if(loginBusiness.isUniqueLogin()){
			success=true;
			utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
			if(utilisateur==null || utilisateur.getId()==null) {
				success=false;
			}else {
				success=loginBusiness.connexion();
			}
		}
		return success;
	}

}
