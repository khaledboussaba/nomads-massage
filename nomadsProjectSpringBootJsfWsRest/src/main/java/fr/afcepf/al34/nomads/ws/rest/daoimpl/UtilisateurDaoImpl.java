package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.UtilisateurDao;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class UtilisateurDaoImpl extends GenericDaoImpl<Utilisateur> implements UtilisateurDao {

	public List<String> getTypeForDB(String userType) {

		return em.createQuery("SELECT t FROM Masseur.id_discriminator_utilisateur t", String.class).getResultList();
	}

	@Override
	public List<Utilisateur> getAllUtilisateurs() {
		return em.createQuery("SELECT m FROM Masseur m", Utilisateur.class).getResultList();
	}

	@Override
	public Utilisateur sauvegarderUtilisateur(Utilisateur utilisateur) {
		// Credential salt etc....
		if (((Utilisateur) utilisateur).getId() == null) {
			utilisateur = insert(utilisateur);
		} else {
			utilisateur = update(utilisateur);
		}
		return utilisateur;
	}

	@Override
	public Utilisateur getUtilisateurById(Long idUtilisateur) {
		return findById(idUtilisateur);
	}

	@Override
	public boolean userNotExisting(String login) {
		return !isUnique(login);
	}
	
	@Override
	public boolean isUnique(String login) {
		boolean isUnique = false;

		Query query = em.createQuery("SELECT u from Utilisateur u WHERE u.credentials.login = :paramLogin");
		query.setParameter("paramLogin", login);
		if (query.getResultList().size() == 1) {
			isUnique = true;
		}

		return isUnique;

	}

	@Override
	public Utilisateur getUserByLogin(String login) {
		Utilisateur utilisateur = null;

		Query query = em.createQuery("SELECT u from Utilisateur u WHERE u.credentials.login = :paramLogin");
		query.setParameter("paramLogin", login);
		if (query.getResultList().size() != 0) {
			utilisateur = (Utilisateur) query.getResultList().get(0);

		}

		return utilisateur;
	}

	@Override
	public Utilisateur getUserByCredentials(Credentials credentials) {
		Utilisateur utilisateur = null;
		
//		System.out.println("login = "+credentials.getLogin());
//		System.out.println("hashed password = "+credentials.getHashedPassword());
//		System.out.println("clear password = "+credentials.getClearPassword());
		
		
		Query query = em.createQuery(
				"SELECT u from Utilisateur u WHERE u.credentials.login = :paramLogin AND u.credentials.hashedPassword = :paramHashedPassword");
		query.setParameter("paramLogin", credentials.getLogin());
		query.setParameter("paramHashedPassword", credentials.getHashedPassword());
		
//		System.out.println("query.getResultList().size()="+query.getResultList().size());
		
		if (query.getResultList().size() != 0) {
			utilisateur = (Utilisateur) query.getResultList().get(0);

		}else {
			return null;
		}

		return utilisateur;
	}

	@Override
	public String getSalt(String login) {
		String salt = null;

		Query query = em.createQuery("SELECT u.credentials.salt from Utilisateur u WHERE u.credentials.login = :paramLogin");
		query.setParameter("paramLogin", login);
		if (query.getResultList().size() != 0) {
			salt = (String) query.getResultList().get(0);

		}

		return salt;
	}

	@Override
	public Credentials getCredentials(String login) {
		Credentials cred=null;

		Query query = em.createQuery("SELECT u.credentials from Utilisateur u WHERE u.credentials.login = :paramLogin");
		query.setParameter("paramLogin", login);
		
//		System.out.println("getCredentials("+login+").size="+query.getResultList().size());
		
		if (query.getResultList().size() != 0) {
			cred= (Credentials) query.getResultList().get(0);

		}

		return cred;
		
	}

}
