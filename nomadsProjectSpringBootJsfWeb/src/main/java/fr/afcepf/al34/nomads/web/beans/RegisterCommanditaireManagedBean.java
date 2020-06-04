package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CommanditaireBusiness;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Contact;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.StatutLieu;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.entities.Type;
import fr.afcepf.al34.nomads.entities.Ville;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean(value = "mbRegisterCommanditaire")
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class RegisterCommanditaireManagedBean implements Serializable {



	/**
	 * 
	 */
	private static final long serialVersionUID = 4410040685457740271L;

	private String error;

	private Commanditaire utilisateur;
	
	private boolean demoUser;

	@Autowired
	CommanditaireBusiness commanditaireBusiness;

	@PostConstruct
	public void initUser() {
		// utilisateur Fields
		utilisateur = new Commanditaire();
		utilisateur.setCredentials(new Credentials());
		utilisateur.setContacts(new ArrayList<Contact>());
		utilisateur.getContacts().add(new Contact());
		utilisateur.getContacts().get(0).setTitre(new Titre());
		utilisateur.setAdresse(new Adresse());
		utilisateur.getAdresse().setVille(new Ville());

		// Commanditaire Fields
		utilisateur.setLieux(new ArrayList<Lieu>());
		utilisateur.getLieux().add(new Lieu());
		utilisateur.getLieux().get(0).setStatut(new StatutLieu());
		utilisateur.getLieux().get(0).setType(new Type());
	}

	public void initUserOnLoad() {
		System.out.println("initOnLoadAdministrateur");
		initUser();
		if(demoUser) {
			utilisateur.getCredentials().setLogin("barDemo");
			utilisateur.getCredentials().setClearPassword("barDemo");
			utilisateur.getContacts().get(0).setNom("Dupond");
			utilisateur.getContacts().get(0).setPrenom("Fabrice");
			utilisateur.getContacts().get(0).setEmail("fab.dupond@yahoo.fr");
			utilisateur.getContacts().get(0).setPosteOccupe("Gerant");
			utilisateur.getContacts().get(0).setNumeroTelephone("01-48-96-32-14");
			utilisateur.getAdresse().setLibelleAdresse("5 rue Raspail");
			utilisateur.getAdresse().getVille().setCodePostal("75019");
			utilisateur.getAdresse().getVille().setLibelle("Paris");
			utilisateur.setNumeroSIRET("456 321 789 00120");
			utilisateur.setRaisonSociale("Joy Organiser Company");
		}
		demoUser=false;
	}
	
	@Autowired
	private LoginBusiness loginBusiness;

	/*
	 * Author Sami
	 */
	public Commanditaire validezCommanditaire() {
		resetIds();
		System.out.println("commanditaireBusiness="+commanditaireBusiness);
		System.out.println("utilisateur="+utilisateur);

		try {
//			System.out.println("sASASASASAssss");
			this.utilisateur=utilisateur=commanditaireBusiness.registerUser(utilisateur);
			
//			System.out.println("this.utilisateur="+this.utilisateur);
			
			return this.utilisateur;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	public void demoRegisteurCommanditaire() {
		
		demoUser=true;
		
	}
	
	public void resetIds() {
		utilisateur.setId(null);
		utilisateur.getCredentials().setId(null);
		utilisateur.getContacts().get(0).setId(null);
		utilisateur.getContacts().get(0).getTitre().setId(null);
		utilisateur.getContacts().get(0).getTitre().setContacts(null);
		
		utilisateur.getAdresse().setId(null);
		utilisateur.getAdresse().getVille().setId(null);

		// Commanditaire Fields
		utilisateur.getLieux().get(0).setId(null);
		utilisateur.getLieux().get(0).getStatut().setId(null);
		utilisateur.getLieux().get(0).getType().setId(null);
	}

	public void disconnect() {
		initUser();
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
