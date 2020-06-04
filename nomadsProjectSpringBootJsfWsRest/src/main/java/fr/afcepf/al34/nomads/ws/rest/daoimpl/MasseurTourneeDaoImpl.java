package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.MasseurTourneeDao;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class MasseurTourneeDaoImpl extends GenericDaoImpl<MasseurTournee> implements MasseurTourneeDao {


	@Override
	public List<MasseurTournee> getListMasseurTournee(Long id) {
		Query query = em.createQuery("SELECT mt FROM MasseurTournee mt WHERE mt.masseur.id = :param");
		query.setParameter("param", id);
		return query.getResultList();
	}
	@Override
	public List<MasseurTournee> getListAllMasseurTournee() {
		Query query = em.createQuery("SELECT mt FROM MasseurTournee mt");
		return query.getResultList();
	}

}
