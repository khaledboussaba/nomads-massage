package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.CatalogueDao;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class CatalogueDaoImpl extends GenericDaoImpl<Produit> implements CatalogueDao  {
 
	@Override
	public List<Produit> getAllProducts() {
		return em.createQuery("SELECT p FROM Produit p", Produit.class).getResultList();
	}
	
	@Override
	public List<PackCredit> getAllPacks() {
		return em.createQuery("SELECT pc FROM PackCredit pc ", PackCredit.class).getResultList();
	}


	@Override
	public List<Tournee> getAllTournees() {
		List<Tournee> tournees = em.createQuery("SELECT t FROM Tournee t ", Tournee.class).getResultList();
		for (Tournee tournee : tournees) {
			//System.out.println(tournee.getId() + " " + tournee.getPrixCredit());
		}
		return tournees;
	}

	@Override
	public List<Materiel> getAllMateriels() {
		return em.createQuery("SELECT m FROM Materiel m ", Materiel.class).getResultList();
	}

	@Override
	public Produit getProduitById(int i) {
		Produit p = em.createQuery("SELECT p FROM PRODUCT p WHERE P.id =:id", Produit.class)
				.setParameter("id", i)
				.getSingleResult();
		
		return p ;
	}
	

	

}
