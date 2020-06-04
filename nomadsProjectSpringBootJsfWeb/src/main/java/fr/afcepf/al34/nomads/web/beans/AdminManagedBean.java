package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CommanditaireBusiness;
import fr.afcepf.al34.nomads.business.LieuBusiness;
import fr.afcepf.al34.nomads.business.LieuTourneeBusiness;
import fr.afcepf.al34.nomads.business.MasseurBusiness;
import fr.afcepf.al34.nomads.business.ProduitBusiness;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.StatutLieu;
import fr.afcepf.al34.nomads.entities.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean(value = "mbAdmin")
@SessionScope
@Getter @Setter @NoArgsConstructor 
public class AdminManagedBean implements Serializable {
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5804020944614335781L;

	@Autowired
	private ProduitBusiness produitBusiness;
	
	@Autowired
	private LieuBusiness lieuBusiness;
	
	@Autowired
	private LieuTourneeBusiness lieuTourneeBusiness;
	
	@Autowired
	private CommanditaireBusiness commanditaireBusiness;
	
	@Autowired
	private MasseurBusiness masseurBusiness;
	
	private List<Produit> listeDesTshirt;
	private List<Produit> listeDesPacksCredits;
	private List<Produit> listeDesTPE;
	private List<Produit> listeDesChaises;
	
	private Long nbTshirtEnStock;
	private Long nbTPEenStock;
	private Long nbPacksProposes;
	private Long nbCahisesEnStock;
	
	private Long nbBarsEnAttente;
	private Long nbBarsActif;
	private Long nbBarsInactif;
	
	private Long nbMasseursEnAttente;
	private Long nbMasseursActif;
	private Long nbMasseursInactif;
	
	private Long nbTourneesAVenir;
	private Long nbTourneesComplete;
	private Long nbTourneesSemiComplete;
	private Long nbTournnesVide;
	
	private List<Lieu> barsEnAttente;
	private List<Tournee> listeDesTournee;
	private List<LieuTournee> lieuxTournees;
	
	private List<Commanditaire> tousLescommanditaires;
	private List<Masseur> tousLesMasseurs;
	
	
	@PostConstruct
	public void init() {
		listeDesTshirt = produitBusiness.recupererLaListeDesTshirt();
		listeDesPacksCredits = produitBusiness.recupererLaListeDesPacks();
		listeDesTPE = produitBusiness.recupererLaListeDesTPE();
		listeDesChaises = produitBusiness.recupererLaListeDesChaises();
		
		nbTshirtEnStock = produitBusiness.recupererLeNombreDeTshirtDisponile();
		nbTPEenStock = produitBusiness.recupererLeNombreDeTPEdisponile();
		nbCahisesEnStock = produitBusiness.recupererLeNombreDeChaisesdisponile();
		nbPacksProposes = produitBusiness.recupererLeNombreFormulesPacks();
		
		nbBarsEnAttente = produitBusiness.recupererLeNombreDeBarEnAttente();
		nbBarsActif = produitBusiness.recupererLeNombreDeBarActifs();
		nbBarsInactif = produitBusiness.recupererLeNombreDeBarInactifs();
		
		//nbMasseursEnAttente
		nbMasseursActif = produitBusiness.recupererLeNombreDeMasseursActifs();
		nbMasseursInactif  = produitBusiness.recupererLeNombreDeMasseursInactifs();
		
		nbTourneesAVenir = produitBusiness.recupererLeNombreDeTourneesAVenir();
		nbTourneesComplete = produitBusiness.recupererLeNombreDeTourneesAVenirEtComplete();
		nbTourneesSemiComplete = produitBusiness.recupererLeNombreDeTourneesAVenirEtSemiComplete();
		nbTournnesVide = produitBusiness.recupererLeNombreDeTourneesAVenirEtVide();
		
		barsEnAttente = produitBusiness.recupererLaListeDesBarsEnAttente();
		listeDesTournee = produitBusiness.recupererLaListeDeToutesLesTournnesAVenir();
		
		lieuxTournees = lieuTourneeBusiness.recupererLesLieuxEtLesTournees();
		
		tousLescommanditaires = commanditaireBusiness.recupererTousLesCommanditaires();
		tousLesMasseurs = masseurBusiness.recupererTousLesMasseur();
	}
	
	public void modifierTshirt() {
		System.out.println("JE SUIS DANS LA MODIFICATION !!!");
	}
	
	public String activerBar(Long idLieu) {
		
		Lieu lieu = lieuBusiness.recupererLieuParSonId(idLieu);
		StatutLieu sl = new StatutLieu();
		sl.setId(2l);
		sl.setLibelle("Valide");
		lieu.setStatut(sl);
		lieu.setActif(true);
		lieu = lieuBusiness.mettreAjourLieu(lieu);
		
		init();
		
		return "/admin/accueilAdmin.xhtml?faces-redirect=true";
		
	}

}
