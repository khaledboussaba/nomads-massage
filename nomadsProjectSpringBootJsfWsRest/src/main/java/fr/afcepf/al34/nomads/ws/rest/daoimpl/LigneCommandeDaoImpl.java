package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.LigneCommandeDao;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;
@Repository
public class LigneCommandeDaoImpl extends GenericDaoImpl<LigneCommande> implements LigneCommandeDao {

	@Override
	public Long getNombreDeCreditAcrediter(Long id) {
		
		System.out.println("SASASASA id="+id);
		
		Query query = em.createQuery("SELECT SUM(p.nombreCredit) FROM LigneCommande lt "
									+ "INNER JOIN Commande c "
									+ "ON lt.commande.id = c.id "
									+ "INNER JOIN PackCredit p "
									+ "ON lt.produit.id = p.id "
									+ "WHERE c.id=:param");
		query.setParameter("param", id);
		List<Long> maList = query.getResultList();
		
		System.out.println("SASASASA maList="+maList);
		
		Long result = 0l;
		if (maList!=null && maList.size() > 0) {
			if(maList.get(0)!=null)
				result = maList.get(0);
		}

		System.out.println("SASASASA result="+result);
		
		
		return result;
	}

}
