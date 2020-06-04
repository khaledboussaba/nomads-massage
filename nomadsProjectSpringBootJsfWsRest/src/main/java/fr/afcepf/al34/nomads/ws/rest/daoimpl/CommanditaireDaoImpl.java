package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.nomads.dao.CommanditaireDao;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.entities.Ville;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;
@Repository
@Transactional
public class CommanditaireDaoImpl extends GenericDaoImpl<Commanditaire> implements CommanditaireDao {
	private Commanditaire administrateur;

	@Override
	public Commanditaire sauvegarderUtilisateur(Commanditaire utilisateur) {
		try {
			utilisateur = (Commanditaire) deepInsertOrUpdate(utilisateur);
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
	public Commanditaire getUtilisateurById(Long idUtilisateur) {
		return (Commanditaire)findById(idUtilisateur);
	}

	/* 
	 * @Author : Khaled
	 */
	@Override
	public List<Commanditaire> getAllCommanditaires() {
		return getAllUsers(Commanditaire.class,"SELECT m FROM Commanditaire m");//em.createQuery("SELECT c FROM Commanditaire c", Commanditaire.class).getResultList();
	}
	
	@Override
	public List<Masseur> getAllUtilisateurs() {
		return getAllUsers(Masseur.class,"SELECT m FROM Masseur m");//em.createQuery("SELECT m FROM Masseur m", Commanditaire.class).getResultList();
	}

	/*
	 * @Author : Sami
	 */
	public <T> List<T> getAllUsers(Class T,String query){
		List<T> users=em.createQuery(query, T).getResultList();
		
		for(Object user:users) {
			Utilisateur u=(Utilisateur)user;
			Ville v=u.getAdresse().getVille();
			int s=u.getAdresse().getVille().getAdresse().size();
			int s2=u.getContacts().size();
			u.getCredentials();
		}
		
		return users;
	}
	

	/* 
	 * @Author : Khaled
	 */
	@Override
	public Commanditaire getCommanditaireWhitId7(Long l) {
		Query query = em.createQuery("SELECT c FROM Commanditaire c WHERE c.id = :param");
		query.setParameter("param", l);
		Commanditaire commanditaire = (Commanditaire) query.getSingleResult();
		return commanditaire;
	}
}
