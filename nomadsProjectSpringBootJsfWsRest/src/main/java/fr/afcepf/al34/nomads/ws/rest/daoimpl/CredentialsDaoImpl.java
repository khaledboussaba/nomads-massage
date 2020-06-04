package fr.afcepf.al34.nomads.ws.rest.daoimpl;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.CredentialsDao;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;
@Repository
public class CredentialsDaoImpl extends GenericDaoImpl<Credentials> implements CredentialsDao {

	@Override
	public Credentials getCredentialsByLogin(String login) {
		Credentials credentials = null;
		Query query = em.createQuery("SELECT c from Credentials c WHERE c.login = :paramLogin");
		query.setParameter("paramLogin", login);
		if(query.getResultList().size() != 0) 
		{
			credentials = (Credentials) query.getResultList().get(0);
		}
		return credentials;
	}

}
