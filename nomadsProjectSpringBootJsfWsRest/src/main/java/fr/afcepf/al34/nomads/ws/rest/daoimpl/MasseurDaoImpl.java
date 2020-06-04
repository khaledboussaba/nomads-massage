package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.MasseurDao;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.entities.Contact;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.entities.Ville;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class MasseurDaoImpl extends GenericDaoImpl<Masseur> implements MasseurDao {

	@Override
	public List<Masseur> getAllUtilisateurs() {
		return getAllMasseurs();
	}

	@Override
	public Masseur sauvegarderUtilisateur(Masseur utilisateur) {
		try {
			utilisateur = (Masseur) deepInsertOrUpdate(utilisateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage()==null) {
				e.printStackTrace();
			}
			System.out.println(e.getMessage());
		}

		return utilisateur;
	}

	@Override
	public Masseur getUtilisateurById(Long idUtilisateur) {
		return (Masseur)findById(idUtilisateur);
	}
	
	@Override
	public boolean loginNoExist(String login) {
		boolean isUnique = false;

		Query query = em.createQuery("SELECT u from Utilisateur u WHERE u.credentials.login = :paramLogin");
		query.setParameter("paramLogin", login);
		if (query.getResultList().size() == 0) {
			isUnique = true;
		}

		return isUnique;

	}
	
	/*
	 * @author: Khaled & Sami
	 */
	@Override
	public List<Masseur> getAllMasseurs() {
		List<Masseur> masseurs=em.createQuery("SELECT m FROM Masseur m", Masseur.class).getResultList();
		for(Masseur m : masseurs) {
			Adresse a=m.getAdresse();
			Ville v= a.getVille();
			v.getAdresse().size();
			List<Contact> cs= m.getContacts();
			cs.size();
			for (Contact c : cs) {
				Titre t=c.getTitre();
			}
		}
		return masseurs;
	}

	@Override
	public Long updateCreditMasseur(Long idMasseur, Long porteMonnaie) {

		Query query = em.createQuery("UPDATE Utilisateur u SET u.porteMonnaie = :paramCredit WHERE u.id = :paramId");
		query.setParameter("paramCredit", porteMonnaie);
		query.setParameter("paramId", idMasseur);

		int nbrQueryChange = query.executeUpdate();
		
		if(nbrQueryChange!=1) {
			throw new RuntimeException("update money query changed "+nbrQueryChange+" witch is different from 1");
		}
		
		Query queryGet = em.createQuery("SELECT u.porteMonnaie from Utilisateur u WHERE u.id = :paramId");
		queryGet.setParameter("paramId", idMasseur);
		
		Long newPorteMonnaie=(long) queryGet.getSingleResult();
		
		return newPorteMonnaie;
	}

	
}
