package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface ProduitServiceDelegate {

	List<Produit> recupererLaListeDesTshirt();

	List<Produit> recupererLaListeDesPacks();

	Long recupererLeNombreDeTshirtDisponile();

	Long recupererLeNombreDeTPEdisponile();

	Long recupererLeNombreFormulesPacks();

	Long recupererLeNombreDeChaisesdisponile();

	List<Produit> recupererLaListeDesTPE();

	List<Produit> recupererLaListeDesChaises();

	Long recupererLeNombreDeBarActifs();

	Long recupererLeNombreDeBarEnAttente();

	Long recupererLeNombreDeBarInactifs();

	Long recupererLeNombreDeMasseursActifs();

	Long recupererLeNombreDeMasseursInactifs();

	Long recupererLeNombreDeTourneesAVenir();

	Long recupererLeNombreDeTourneesAVenirEtComplete();

	Long recupererLeNombreDeTourneesAVenirEtSemiComplete();

	Long recupererLeNombreDeTourneesAVenirEtVide();

	List<Lieu> recupererLaListeDesBarsEnAttente();

	List<Tournee> recupererLaListeDeToutesLesTournnesAVenir();

}
