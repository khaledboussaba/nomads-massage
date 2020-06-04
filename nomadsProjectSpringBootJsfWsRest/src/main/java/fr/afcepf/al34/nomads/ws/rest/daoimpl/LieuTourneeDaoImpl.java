package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.LieuTourneeDao;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Ville;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class LieuTourneeDaoImpl extends GenericDaoImpl<LieuTournee> implements LieuTourneeDao {

	@Override
	public List<LieuTournee> getAllLieuAndTournees() {
		String query = "SELECT lt FROM LieuTournee lt " + "INNER JOIN Tournee t " + "ON lt.tournee.id = t.id ";// +
																												// "WHERE
		List<LieuTournee> lts = em.createQuery(query, LieuTournee.class).getResultList();

		for (LieuTournee lt : lts) {
			Tournee t = lt.getTournee();
			Date d1 = t.getDate();
			Date d2 = t.getHeureDebut();
			Date d3 = t.getHeureFin();
		}

		return lts;
	}

	@Override
	public List<LieuTournee> getAllLieuAndTourneesCommanditaire(Long id) {
		Query query = em.createQuery("SELECT lt FROM LieuTournee lt " + "INNER JOIN Lieu l " + "ON lt.lieu.id = l.id "
				+ "INNER JOIN Tournee t " + "ON lt.tournee.id = t.id " + "INNER JOIN Commanditaire c "
				+ "ON c.id = l.commanditaire.id " + "WHERE c.id = :param " + "AND t.date > NOW() " + "ORDER BY t.date");
		query.setParameter("param", id);
		return query.getResultList();
	}

	@Override
	public List<LieuTournee> getAllLieuAndTournees(Long id) {
		Query query = em.createQuery(
				"SELECT lt FROM LieuTournee lt " + "INNER JOIN MasseurTournee mt " + "ON lt.tournee.id = mt.tournee.id "
						+ "WHERE mt.masseur.id = :param " + "AND mt.tournee.date > NOW()");
		query.setParameter("param", id);
		return query.getResultList();
	}

//	@Override
//	public List<LieuTournee> getLieuxTourneesDisponibles(Long id) {
//		String query = "Select lt FROM LieuTournee lt "
//				+ "WHERE lt.tournee.date > NOW() ";
//		return em.createQuery(query, LieuTournee.class).getResultList();
//	}

	@Override
	public List<LieuTournee> getLieuxTourneesDisponibles() {
		Query query = em.createQuery("SELECT lt FROM LieuTournee lt " + "WHERE lt.tournee.date > NOW() ");
//		return em.createQuery(query, LieuTournee.class).getResultList();
		return query.getResultList();
	}

	@Override
	public List<LieuTournee> getLieuxTourneesDisponibles(Long id) {
//		Query query = em.createQuery("SELECT lt FROM LieuTournee lt "
//									+ "LEFT JOIN MasseurTournee mt "
//									+ "ON lt.tournee.id = mt.tournee.id "
//									+"WHERE lt.tournee.date > NOW() ");

//		String req = "SELECT lt FROM LieuTournee lt "
//		+ "JOIN MasseurTournee mt "
//		+ "ON lt.tournee.id = mt.tournee.id "
//		+ "WHERE size(lt.tournee.masseurTournees) < 2 AND mt.masseur.id != :paramId";

//		String req = "SELECT lt FROM LieuTournee lt "
//				+ "LEFT OUTER JOIN MasseurTournee mt "
//				+ "ON lt.tournee.id = mt.tournee.id "
//					+ "WHERE size(lt.tournee.masseurTournees) < 2 AND mt.masseur.id != :paramId";

		String req = "SELECT lt FROM LieuTournee lt ";// + "WHERE lt.tournee.date > NOW() ";
		Query query = em.createQuery(req);
//		query.setParameter("paramId", id);
		
		List<LieuTournee> t = query.getResultList();
		List<LieuTournee> t2 = new ArrayList<LieuTournee>();
		for (LieuTournee lieuTournee : t) {
			Ville v = lieuTournee.getLieu().getAdresse().getVille();
			v.getAdresse().size();
			Date dd = lieuTournee.getTournee().getHeureDebut();
			Date ddd = lieuTournee.getTournee().getDate();
			Date df = lieuTournee.getTournee().getHeureFin();
			lieuTournee.getLieuCompteRendus().size();
			if (lieuTournee!=null && lieuTournee.getTournee() != null && lieuTournee.getTournee().getMasseurTournees()!=null) {
				if (lieuTournee.getTournee().getMasseurTournees().size() == 0) {

					t2.add(lieuTournee);
				} else {
					for (MasseurTournee mt : lieuTournee.getTournee().getMasseurTournees()) {
						if (mt!=null && mt.getMasseur()!=null && (mt.getMasseur().getId() != id && mt.getTournee().getMasseurTournees().size() < 2)) {
							t2.add(lieuTournee);
						}
					}
				}
			}

		}

		return t2;
	}

	@Override
	public void ajouterUnLieuTournee(LieuTournee lt) {

		em.persist(lt);

	}

}
