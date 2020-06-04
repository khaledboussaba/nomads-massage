package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.ArticleFournisseur;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface ProduitDao extends GenericDao<Produit> {

	List<Produit> getTshirtsList();

	List<Produit> getPacksList();

	Long getCountTshirtInStock();

	Long getCountTPEinStock();

	Long getCountPacksFormules();

	Long getCountChaises();

	List<Produit> getAllTPE();

	List<Produit> getAllChaises();

	Long getCountBarsEnAttente();

	Long getCountActiveBars();

	Long getCountInactiveBars();

	Long getCountMasseursActif();

	Long getCountMasseursInactif();

	Long getCountTourneesAVenir();

	Long getCountTourneesAVenirEtComplete();

	Long getCountTourneesAVenirEtSemiComplete();

	Long getCountTourneesAVenirEtVide();

	List<Lieu> getAllBarsEnAttente();

	List<Tournee> getAllTourneesAVenir();

	ArticleFournisseur findByIdFournisseur(ArticleFournisseur article);

}
