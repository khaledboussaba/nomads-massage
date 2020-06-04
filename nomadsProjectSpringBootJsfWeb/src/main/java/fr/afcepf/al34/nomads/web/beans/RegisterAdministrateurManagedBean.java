package fr.afcepf.al34.nomads.web.beans;

import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.faces.validator.ValidatorException;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.AdministrateurBusiness;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.entities.Contact;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.entities.Ville;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Named(value = "mbRegisterAdministrateur")
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class RegisterAdministrateurManagedBean implements Serializable {

	

	/**
	 * 
	 */
	private static final long serialVersionUID = -1350481082125362509L;

	private String error;

	private Administrateur utilisateur;

	private boolean adminLoggedIn = false;

	@Autowired
	AdministrateurBusiness administrateurBusiness;

	@PostConstruct
	public void initUser() {
		// utilisateur Fields
		utilisateur = new Administrateur();
		utilisateur.setCredentials(new Credentials());
		utilisateur.setContacts(new ArrayList<Contact>());
		utilisateur.getContacts().add(new Contact());
		utilisateur.getContacts().get(0).setTitre(new Titre());
		utilisateur.setAdresse(new Adresse());
		utilisateur.getAdresse().setVille(new Ville());
		utilisateur.getAdresse().getVille().setLibelle("libeller");
		utilisateur.getAdresse().getVille().setAdresse(new ArrayList<Adresse>());
		utilisateur.getAdresse().getVille().getAdresse().add(new Adresse());

//		System.err.println("size "+ utilisateur.getContacts().size() + utilisateur.getContacts().get(0).get);

		// Administrateur Fields

	}

	@Autowired
	private LoginBusiness loginBusiness;

	/*
	 * Author Sami
	 */
	public Administrateur validezAdministrateur() {
		// resetIds();
		if (adminLoggedIn) {
			try {
				if (administrateurBusiness.registerUser(utilisateur)) {
					return utilisateur;
				}
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return null;
	}

	public void disconnect() {
		adminLoggedIn=false;
		initUser();
		
	}

	public void initUserOnLoad() throws IOException {
		if (!adminLoggedIn) {
			ExternalContext ec = FacesContext.getCurrentInstance().getExternalContext();
			ec.redirect(ec.getRequestContextPath() + "/index.jsf");
		}

		initUser();
	}

	public void resetIds() {

		utilisateur.setId(null);
		utilisateur.getCredentials().setId(null);
		utilisateur.getContacts().get(0).setId(null);
		utilisateur.getContacts().get(0).getTitre().setId(null);
		utilisateur.getAdresse().setId(null);
		utilisateur.getAdresse().getVille().setId(null);
		utilisateur.getAdresse().getVille().setAdresse(new ArrayList<Adresse>());
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
