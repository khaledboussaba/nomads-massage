package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.AdministrateurDao;
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class AdministrateurDaoImpl extends GenericDaoImpl<Administrateur> implements AdministrateurDao {

	private Administrateur administrateur;

	@Override
	public List<Administrateur> getAllUtilisateurs() {
		return em.createQuery("SELECT m FROM Masseur m", Administrateur.class).getResultList();
	}

	@Override
	//@Transactional
	public Administrateur sauvegarderUtilisateur(Administrateur utilisateur) {
		
		try {
			utilisateur = (Administrateur) deepInsertOrUpdate(utilisateur);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			if(e.getMessage()==null) {
				e.printStackTrace();
			}
			System.out.println(e.getMessage());
		}
		//em.flush();
		return utilisateur;
	}

	@Override
	public Administrateur getUtilisateurById(Long idUtilisateur) {
		return (Administrateur)findById(idUtilisateur);
	}
}
