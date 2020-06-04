package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.business.StaticListBusiness;
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean(value = "mbLoginOld")
@Getter @Setter @NoArgsConstructor 
@SessionScope
public class LoginManagedBeanOld implements Serializable  {
	
	private String panierString="";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4394298395708250250L;

	@PostConstruct
	public void initAll() {
		populateTitreList();
		populateCodePostaux();
		populateVilleList();


//		System.out.println(titreList);
//		System.out.println(codePostaux);
//		System.out.println("VILLES : "+villeList);
	}
	
	private String login;
	private String clearPassword;
	
	
	private Utilisateur utilisateur;
	
	public Utilisateur getUtilisateur() {
		if(utilisateur==null) {
			return loginBusiness.getUtilisateur();
		}
		return utilisateur;
	}
	
	@Autowired
	private LoginBusiness loginBusiness; 
	
	@Autowired 
	private RegisterCommanditaireManagedBean registerCommanditaireManagedBean;
	
	@Autowired 
	private RegisterMasseurManagedBean registerMasseurManagedBean;	
	
	@Autowired 
	private RegisterAdministrateurManagedBean registerAdministrateurManagedBean;
	
	@Autowired 
	private CatalogueManagedBean catalogueManagedBean;
	
	private List<Titre> titreList;
	private List<String> codePostaux;
	private List<String> villeList;
	private String villeListString;
	
	@Autowired
	private StaticListBusiness staticListBusiness;
	
	public String connexion() throws Exception {
		Credentials credentials=new Credentials();
		credentials.setLogin(login);
		credentials.setClearPassword(clearPassword);
		
		setUtilisateur((Utilisateur)loginBusiness.getUserByCredentials(credentials));
		
		if(estAdministrateur()) registerAdministrateurManagedBean.setAdminLoggedIn(true);
		
		return (utilisateur!=null) ? getSuccess() : "failure";
	}

	public void onDisconnect() {
		loginBusiness.setUtilisateur(null);
		utilisateur=null;
		registerAdministrateurManagedBean.disconnect();
		registerMasseurManagedBean.disconnect();
		registerCommanditaireManagedBean.disconnect();
		FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
	}

	public boolean estMasseur() {
		boolean ret=false;
		if(getUtilisateur()!=null && getUtilisateur().getClass()==Masseur.class) {
			ret=true;
		}
		return ret;
	}
	
	public boolean estCommanditaire() {
		boolean ret=false;
		if(getUtilisateur()!=null && getUtilisateur().getClass()==Commanditaire.class) {
			ret=true;
		}
		return ret;
	}
	
	public boolean estAdministrateur() {
		boolean ret=false;
		if(getUtilisateur()!=null && getUtilisateur().getClass()==Administrateur.class) {
			ret=true;
		}
		return ret;
	}
	
	public boolean estVisiteur() {
		boolean ret=false;
		if(getUtilisateur()==null) {
			ret=true;
		}
		return ret;
	}
	
	public String failureAction() {
		return "login";
	}
	
	public String validezMasseur() {
		setUtilisateur((Utilisateur)registerMasseurManagedBean.validezMasseur());
		login=getUtilisateur().getCredentials().getLogin();
		clearPassword="";
		setUtilisateur((Utilisateur)loginBusiness.getUserByCredentials(getUtilisateur().getCredentials()));
		System.out.println("validezMasseur()="+getUtilisateur());
		if(getUtilisateur()!=null) {
			return "indexMasseur";
		}
		return "";
	}
	
	public String validezCommanditaire() {
		System.out.println("registerCommanditaireManagedBean="+registerCommanditaireManagedBean);
		
		Commanditaire c=registerCommanditaireManagedBean.validezCommanditaire();
		setUtilisateur(c);

		setUtilisateur((Utilisateur)loginBusiness.getUserByCredentials(getUtilisateur().getCredentials()));
		
		login=getUtilisateur().getCredentials().getLogin();
		clearPassword="";
		System.out.println("validezCommanditaire()="+getUtilisateur());
		if(getUtilisateur()!=null) {
			return "indexCommanditaire";
		}
		return "";
	}
	
	public String validezAdministrateur() {
		Administrateur admin = registerAdministrateurManagedBean.validezAdministrateur();
		setUtilisateur(admin);

		login=getUtilisateur().getCredentials().getLogin();
		clearPassword="";
		
		setUtilisateur((Utilisateur)loginBusiness.getUserByCredentials(getUtilisateur().getCredentials()));

		if(admin!=null) {
			return "indexAdministrateur";
		}
		return "";
	}
	
	public void validateAField(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String inputValue = (String) value;
		if (inputValue.contains("/")) {
			FacesMessage msg = new FacesMessage("mauvais format : doit contenir un a");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
	
	public String demoConnexionCommanditaire() throws Exception {
		login="bar";
		clearPassword="bar";
		return connexion();
	}
	
	public String demoConnexionMasseur() throws Exception {
		login="masseur";
		clearPassword="masseur";
		return connexion();
	}
	
	public String demoConnexionAdmin() throws Exception {
		login="admin";
		clearPassword="admin";
		return connexion();
	}
	
	private void populateTitreList() {
		titreList = staticListBusiness.getListTitre();
	}
	
	private void populateCodePostaux() {
		codePostaux = staticListBusiness.getListCodePostaux(); 
	}
	
	private void populateVilleList() {
		villeList = staticListBusiness.getListVille(); 
	}
	
	public String getSuccess() {
		if(estAdministrateur())
			return "/admin/accueilAdmin.xhtml?faces-redirect=true";
		else if(estCommanditaire())
			return "/commanditaire/accueilCommanditaire.xhtml?faces-redirect=true";
		else
			return "/masseur/accueilMasseur.xhtml?faces-redirect=true";
	}
	
	
	public String getPanierString() {
		if(estMasseur() && catalogueManagedBean!=null) {
			
			int nbrsProduits;
			
			nbrsProduits=catalogueManagedBean.getQteProduitPanier();
			return "Panier("+nbrsProduits+")";
		}
		return "Panier(vide)"; 
	}
	
}
