package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.TourneeDao;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class TourneeDaoImpl extends GenericDaoImpl<Tournee> implements TourneeDao {

/*
	@Override
	public List<Tournee> getAllTourneesDispo(Long id) {
		Query query = em.createNativeQuery("SELECT "
				+ "p.id_produit, p.date, t.id_lieu, l.nom, p.heure_debut," + 
				"	  p.heure_debut_imperative, p.heure_fin, p.prix_credit, u.nom_masseur as binome" + 
				"	  FROM nomads_bdd.produit as p " + 
				"	  INNER JOIN nomads_bdd.lieu_tournee as t ON p.id_produit = t.id_tournee" + 
				"	  INNER JOIN nomads_bdd.lieu as l ON l.id_lieu = t.id_lieu " + 
				"	 INNER JOIN nomads_bdd.masseur_tournee as mt ON p.id_produit = mt.id_tournee" + 
				"	  INNER JOIN utilisateur as u ON mt.id_masseur = u.id_utilisateur" + 
				"	  WHERE p.date > NOW()");
		List<Object[]> tourn = query.getResultList();
		List<Tournee> tournees = new ArrayList<Tournee>();
		for (Object[] o : tourn) {
			System.out.println(o[0] );
		}
		
		
		return null;
	}
	*/
	
	@Override
	public List<LieuTournee> getAllTourneesDispo(Long id) {
/*		
//		Query query = em.createQuery("SELECT "
//				+ ", l.nom"
//				+ ", t.heureDebut"
//				+ ", t.heureDebutImperative"
//				+ ", t.heureFin"
//				+ ", t.prixCredit"
//				+ ", m.prenomMasseur"
//				+ " FROM Tournee t "
//				+ "	INNER JOIN LieuTournee lt ON t.id = lt.tournee.id"
//				+ " INNER JOIN Lieu l ON l.id = lt.lieu.id "
//				+ " INNER JOIN MasseurTournee mt ON t.id = mt.tournee.id "
//				+ " INNER JOIN Masseur m ON mt.masseur.id = m.id "
//				+ "WHERE t.date > NOW()");
*/
		Query query = em.createQuery("SELECT t FROM Tournee t " + "WHERE t.date > NOW()");
		return query.getResultList();
	}


	 
	@Override
	public List<Tournee> getTourneesMasseur(Long id) {
		List<Tournee> result = new ArrayList<Tournee>();
		
		Query query = em.createQuery("SELECT m FROM Masseur m WHERE m.id = :idMasseur", Masseur.class);
		query.setParameter("idMasseur", id);

		for (Object object : query.getResultList()) {
			Masseur masseur = ((Masseur) object);
			
			List<MasseurTournee> masseurTournee = masseur.getMasseurTournees();
			for (MasseurTournee tournee : masseurTournee) {
				tournee.getTournee().getLieuTournee().size();
				tournee.getTournee().getMasseurTournees().size();

				result.add(tournee.getTournee());
			}

		}
		
		return result;
	}

	@Override
	public List<Masseur> getTourneesMasseur(List<Tournee> tournees) {
		List<Masseur> result = new ArrayList<Masseur>();
		
		Query query = em.createQuery("SELECT m FROM Masseur m", Masseur.class);

		for (Object object : query.getResultList()) {
			Masseur masseur = ((Masseur) object);
			
			List<MasseurTournee> masseurTournee = masseur.getMasseurTournees();
			for (MasseurTournee tournee : masseurTournee) {
				tournee.getTournee().getLieuTournee().size();
				tournee.getTournee().getMasseurTournees().size();
				
				for(Tournee tourneeFromList : tournees) {
					if(tournee.getTournee().getId()==tourneeFromList.getId()) {
						result.add(masseur);
					}
				}
			}
		}
//		System.out.println("sasasasa"+result);
		return result;
	}
	
}
