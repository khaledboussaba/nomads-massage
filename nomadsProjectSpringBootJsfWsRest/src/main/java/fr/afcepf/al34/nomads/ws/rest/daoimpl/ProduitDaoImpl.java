package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import java.util.Date;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.ProduitDao;
import fr.afcepf.al34.nomads.entities.ArticleFournisseur;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Ville;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class ProduitDaoImpl extends GenericDaoImpl<Produit> implements ProduitDao {


	@Override
	public List<Produit> getTshirtsList() {
		List<Produit> lps=em.createQuery("SELECT p FROM Produit p WHERE p.categorie = 'T- Shirt' ORDER BY p.taille", Produit.class).getResultList();
		
		return lps;
	}

	@Override
	public List<Produit> getPacksList() {
		return em.createQuery("SELECT p FROM Produit p WHERE p.libelle IS NOT NULL", Produit.class).getResultList();
	}

	@Override
	public Long getCountTshirtInStock() {
		String query = "SELECT SUM(p.quantite) FROM Produit p WHERE p.categorie = 'T- Shirt'";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountTPEinStock() {
		String query = "SELECT SUM(p.quantite) FROM Produit p WHERE p.categorie = 'Terminal Paiement'";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountChaises() {
		String query = "SELECT SUM(p.quantite) FROM Produit p WHERE p.categorie = 'Chaise Ergonomique'";
		return (Long) em.createQuery(query).getSingleResult();
	}
	
	@Override
	public Long getCountPacksFormules() {
		String query = "SELECT COUNT(p.libelle) FROM Produit p WHERE p.libelle IS NOT NULL";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public List<Produit> getAllTPE() {
		return em.createQuery("SELECT p FROM Produit p WHERE p.categorie = 'Terminal Paiement'", Produit.class).getResultList();
	}

	@Override
	public List<Produit> getAllChaises() {
		return em.createQuery("SELECT p FROM Produit p WHERE p.categorie = 'Chaise Ergonomique'", Produit.class).getResultList();
	}

	@Override
	public Long getCountActiveBars() {
		String query = "SELECT COUNT(l) FROM Lieu l WHERE l.actif = true";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountBarsEnAttente() {
		String query = "SELECT COUNT(l) FROM Lieu l WHERE l.statut.id = 1";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountInactiveBars() {
		String query = "SELECT COUNT(l) FROM Lieu l WHERE l.actif = false";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountMasseursActif() {
		String query = "SELECT COUNT(m) FROM Masseur m WHERE m.actif = true";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountMasseursInactif() {
		String query = "SELECT COUNT(m) FROM Masseur m WHERE m.actif = false";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountTourneesAVenir() {
		String query = "SELECT COUNT(t) FROM Tournee t WHERE t.date > NOW()";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountTourneesAVenirEtComplete() {
		String query = "SELECT COUNT(t) FROM Tournee t "
				+ "WHERE (SELECT COUNT(mt) FROM MasseurTournee mt WHERE mt.tournee.id = t.id) = 2 "
				+ "AND t.date > NOW()";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountTourneesAVenirEtSemiComplete() {
		String query = "SELECT COUNT(t) FROM Tournee t "
				+ "WHERE (SELECT COUNT(mt) FROM MasseurTournee mt WHERE mt.tournee.id = t.id) = 1 "
				+ "AND t.date > NOW()";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public Long getCountTourneesAVenirEtVide() {
		String query = "SELECT COUNT(t) FROM Tournee t "
				+ "WHERE (SELECT COUNT(mt) FROM MasseurTournee mt WHERE mt.tournee.id = t.id) = 0 "
				+ "AND t.date > NOW()";
		return (Long) em.createQuery(query).getSingleResult();
	}

	@Override
	public List<Lieu> getAllBarsEnAttente() {
		String query = "SELECT l FROM Lieu l WHERE l.statut.id = 1";
		List<Lieu> lieux=em.createQuery(query, Lieu.class).getResultList();
		for(Lieu l:lieux) {
			Ville v=l.getAdresse().getVille();
			v.getAdresse().size();
		}
		return lieux;
	}

	@Override
	public List<Tournee> getAllTourneesAVenir() {
		String query = "SELECT t FROM Tournee t WHERE t.date > NOW()";
		List<Tournee> tournees=em.createQuery(query, Tournee.class).getResultList();
		for(Tournee t:tournees){
			Date t1=t.getDate();
			Date t2=t.getHeureDebut();
			Date t3=t.getHeureFin();
			for(LieuTournee l:t.getLieuTournee()) {
				Ville v=l.getLieu().getAdresse().getVille();
				v.getAdresse().size();
			}
			
		}
		return tournees;
	}

	@Override
	public ArticleFournisseur findByIdFournisseur(ArticleFournisseur article) {
		String query = "SELECT p FROM Produit p WHERE p.idArticle = :idArticle";
		ArticleFournisseur retArticle=null;
		try {
			Query q=em.createQuery(query).
					setParameter("idArticle", article.getIdArticle());
			retArticle=(ArticleFournisseur) q.getSingleResult();
			
		}
		catch (Exception e) {
			retArticle = null;
			// TODO: handle exception
		}
		return retArticle;
	}

}
