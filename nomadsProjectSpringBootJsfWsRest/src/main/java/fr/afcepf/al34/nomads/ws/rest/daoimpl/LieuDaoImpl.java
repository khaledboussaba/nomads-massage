package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.LieuDao;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class LieuDaoImpl extends GenericDaoImpl<Lieu> implements LieuDao {


	@Override
	public Lieu getLieuById(Long idLieu) {
		Query query = em.createQuery("SELECT l FROM Lieu l WHERE l.id = :param");
		query.setParameter("param", idLieu);
		Lieu lieu = (Lieu) query.getSingleResult();
		return lieu;
	}

	@Override
	public Lieu updateLieu(Lieu lieu) {
		em.merge(lieu);
		//em.flush();
		return lieu;
	}

	@Override
	public List<Lieu> getLieuxCommanditaire(Long id) {
		Query query = em.createQuery("SELECT l FROM Lieu l WHERE l.commanditaire.id = :param");
		query.setParameter("param", id);
		List<Lieu> lieux = query.getResultList();
		
//		System.out.println("SASASASAASA"+id);
//		System.out.println("SASASASAASA"+lieux);
		
		return lieux;
	}
	
	@Override
	public List<Lieu> getLieuxActifsCommanditaire(Long id) {
		Query query = em.createQuery("SELECT l FROM Lieu l "
									+ "WHERE l.commanditaire.id = :param "
									+ "AND (l.statut.id = 2 OR l.actif = true)");
		query.setParameter("param", id);
		List<Lieu> lieux = query.getResultList();
		return lieux;
	}

}
