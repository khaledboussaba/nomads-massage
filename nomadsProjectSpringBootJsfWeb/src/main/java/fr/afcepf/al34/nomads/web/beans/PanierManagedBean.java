package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CatalogueBusiness;
import fr.afcepf.al34.nomads.business.CommandeBusiness;
import fr.afcepf.al34.nomads.business.LigneCommandeBusiness;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.business.MasseurBusiness;
import fr.afcepf.al34.nomads.dto.CommandeDto;
import fr.afcepf.al34.nomads.dto.LigneCommandeDto;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.entities.Masseur;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean("mbPanier")
@Getter
@Setter
@NoArgsConstructor
@SessionScope
public class PanierManagedBean implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2451925568974048657L;

	@Autowired
	private LoginBusiness loginBusiness;

	@Autowired
	private CatalogueBusiness catalogueService;

	@Autowired
	private LigneCommandeBusiness lcBusiness;

	@Autowired
	private CommandeBusiness commandeBusiness;

	@Autowired
	private MasseurBusiness masseurBusiness;

	@Autowired
	private CatalogueManagedBean mbCatalogue;

	@Autowired
	private CatalogueWebServiceManagedBean mbCatalogueWebServiceManagedBean;

	@Autowired
	private MasseurManagedBean mbMasseur;

	private List<LigneCommande> lignes = new ArrayList<LigneCommande>();

	private Masseur masseur;

	private Long nbCreditsAcrediter;

	private Commande commandeASauvegarder = new Commande();

	@PostConstruct
	public void init() {

	}

	public String passerEnCaisse() {

		return "paiement.xthml?faces-redirect=true";
	}

	public String enregistrerCommande() {
		masseur = (Masseur) loginBusiness.getUtilisateur();
		CommandeDto cdto = new CommandeDto();
		cdto.setDate(new Date());
		cdto.setMasseurId(masseur.getId());
		lignes = mbCatalogueWebServiceManagedBean.getLignesCommande();

		List<LigneCommandeDto> lignesDto = new ArrayList<LigneCommandeDto>();
		for (LigneCommande ligne : lignes) {
			LigneCommandeDto ligneDto = new LigneCommandeDto(ligne);
			lignesDto.add(ligneDto);
		}
		
		cdto.setLignes(lignesDto);
		
		cdto = masseurBusiness.enregistrerCommande(cdto);
		masseur = masseurBusiness.recupererLeMasseur(masseur.getId());
		loginBusiness.setUtilisateur(masseur);
		mbMasseur.setMasseur(masseur);

		commandeASauvegarder.setId(cdto.getIdCommande());

		lignes.clear();

		return "commande_success.xthml?faces-redirect=true";
	}

}
