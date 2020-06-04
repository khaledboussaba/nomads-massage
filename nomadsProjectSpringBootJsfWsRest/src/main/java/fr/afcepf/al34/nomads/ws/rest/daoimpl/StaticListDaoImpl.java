package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.StaticListDao;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;
@Repository
public class StaticListDaoImpl extends GenericDaoImpl<Object> implements StaticListDao {

	@Override
	public List<Titre> getListTitre() {
		Query query = em.createQuery("SELECT t from Titre t");
		
		return (List<Titre>)query.getResultList();
	}

	@Override
	public List<String> getCodePostaux() {
		Query query = em.createQuery("SELECT cp.codePostal from Ville cp");
		return (List<String>)query.getResultList();
	}

	@Override
	public List<String> getList() {
		Query query = em.createQuery("SELECT DISTINCT cp.libelle from Ville cp");
		return (List<String>)query.getResultList();
	}

}
