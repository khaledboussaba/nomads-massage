package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.business.MasseurBusiness;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.entities.Contact;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Disponibilite;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.entities.Ville;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Named(value = "mbRegisterMasseur")
@SessionScope
@Getter @Setter @NoArgsConstructor 
public class RegisterMasseurManagedBean implements Serializable  {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -9189837336098090846L;
	private String login;
	private String clearPassword;
	private String email;
	
	private Masseur utilisateur;
	
	@Autowired
	MasseurBusiness masseurBusiness;
	
	@PostConstruct
	public void initUser(){
		//utilisateur Fields
		utilisateur=new Masseur();
		utilisateur.setCredentials(new Credentials());
		utilisateur.setContacts(new ArrayList<Contact>());
		utilisateur.getContacts().add(new Contact());
		utilisateur.getContacts().get(0).setTitre(new Titre());
		utilisateur.setAdresse(new Adresse());
		utilisateur.getAdresse().setVille(new Ville());
		utilisateur.getAdresse().getVille().setLibelle("libeller");
		
		//Masseur Field
		utilisateur.setDisponibilite(new ArrayList<Disponibilite>());
		utilisateur.getDisponibilite().add(new Disponibilite());
		utilisateur.setMasseurTournees(new ArrayList<MasseurTournee>());
		utilisateur.getMasseurTournees().add(new MasseurTournee());
	}
	
	public void initUserOnLoad() {
		System.out.println("initOnLoadAdministrateur");
		initUser();
	}
	
	@Autowired
	private LoginBusiness loginBusiness; 

	
	public void disconnect() {
		initUser();
	}

	public Masseur validezMasseur() {
		resetIds();
		
		try {
			if(masseurBusiness.registerUser(utilisateur)) {
				return utilisateur;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void resetIds() {
		utilisateur.setId(null);
		utilisateur.getCredentials().setId(null);
		utilisateur.getContacts().get(0).setId(null);
		utilisateur.getContacts().get(0).getTitre().setId(null);
		utilisateur.getAdresse().setId(null);
		utilisateur.getAdresse().getVille().setId(null);
		
		//Masseur Field
		utilisateur.getDisponibilite().get(0).setId(null);
		utilisateur.getMasseurTournees().get(0).setId(null);
	}
	
	public void validateAField(FacesContext context, UIComponent component, Object value) throws ValidatorException {
		String inputValue = (String) value;
		if (inputValue.contains("/")) {
			FacesMessage msg = new FacesMessage("mauvais format : doit contenir un a");
			msg.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(msg);
		}

	}
}
