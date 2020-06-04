package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CommandeBusiness;
import fr.afcepf.al34.nomads.business.LieuTourneeBusiness;
import fr.afcepf.al34.nomads.business.LigneCommandeBusiness;
import fr.afcepf.al34.nomads.business.LoginBusiness;
import fr.afcepf.al34.nomads.business.MasseurBusiness;
import fr.afcepf.al34.nomads.business.MasseurTourneeBusiness;
import fr.afcepf.al34.nomads.business.TourneeBusiness;
import fr.afcepf.al34.nomads.dto.TournerBuyDto;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.entities.Tournee;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean(value = "mbMasseur")
@SessionScope
@Getter
@Setter
@NoArgsConstructor
public class MasseurManagedBean implements Serializable {
	private static final long serialVersionUID = -6180907226425729452L;

	@Autowired
	private MasseurBusiness masseurBusiness;

	@Autowired
	private MasseurTourneeBusiness masseurTourneeBusiness;

	@Autowired
	private LieuTourneeBusiness lieuTourneeBusiness;

	@Autowired
	private TourneeBusiness tourneeBusiness;

	@Autowired
	private CommandeBusiness commandeBusiness;

	@Autowired
	private LigneCommandeBusiness lcBusiness;

	@Autowired
	private LoginBusiness loginBusiness;
	
	@Autowired
	private GlobalMangedBean globalMangedBean;
	
	private Masseur masseur;

	private List<MasseurTournee> masseursTournees;

	private List<LieuTournee> lieuxTournees;

	private List<LieuTournee> tourneesDisponibles;

	private List<Tournee> mesTournees;

	private List<Masseur> masseurInscritMesTournees;

	private List<LieuTournee> tourneesDisponiblesSansMesTournees;

	@PostConstruct
	public void init() {
		masseur = (Masseur) loginBusiness.getUtilisateur();
		if (masseur != null) {
			masseur = masseurBusiness.recupererLeMasseur(masseur.getId());
			masseursTournees = masseurTourneeBusiness.recupererLaListeDesMasseursTournee(masseur.getId());
			lieuxTournees = lieuTourneeBusiness.recupererLesLieuxEtLesTournees(masseur.getId());
			tourneesDisponibles = lieuTourneeBusiness.recupererLesLieuxTourneesDisponibles();
			mesTournees = tourneeBusiness.recupererLaListeDesTourneesDuMasseur(masseur.getId());
			masseurInscritMesTournees = tourneeBusiness.recupererLaListeDesMasseurInscritTournees(mesTournees);
			tourneesDisponiblesSansMesTournees = lieuTourneeBusiness
					.recupererLesLieuxTourneesDisponibles(masseur.getId());

		}
	}

	public String inscrireTournee(Tournee tournee) {
		if (masseur.getPorteMonnaie() > 0 && tournee.getPrixCredit() <= masseur.getPorteMonnaie()) {
			
			TournerBuyDto tbdto=new TournerBuyDto(tournee, masseursTournees, masseur);
			
			tbdto=masseurBusiness.buyTournee(tbdto);
			masseur=tbdto.getMasseur();
			masseursTournees = tbdto.getMasseurTournees();
			tournee = tbdto.getTournee();
					
			tourneesDisponiblesSansMesTournees = lieuTourneeBusiness
					.recupererLesLieuxTourneesDisponibles(masseur.getId());
			mesTournees = tourneeBusiness.recupererLaListeDesTourneesDuMasseur(masseur.getId());
			
			return "/masseur/accueilMasseur.xhtml?faces-redirect=true";
		} else
			return "/masseur/porteMonnaieInsuffisant.xhtml?faces-redirect=true";
	}

	public String afficherTourneeImperative(boolean isImperatif) {
		if (isImperatif) {
			return "oui";
		} else
			return "non";
	}

	public String annulerTournee(Tournee tournee) {
		System.out.println("Se retirer de la tournée " + tournee.getId());
		return null;
	}

	public String getMasseurFor(Long idTourne) {
		for (Masseur m : masseurInscritMesTournees) {
			for (MasseurTournee mt : m.getMasseurTournees()) {

				if (mt.getTournee() != null) {
					if (mt.getTournee().getId() == idTourne && m.getId() != masseur.getId()) {
						return m.getPrenomMasseur();
					}
				}
			}

		}
		return "";
	}

	public Lieu getAdresseStringMasseur(Tournee tournee) {
		
		Lieu result = new Lieu();
		
		if(lieuxTournees==null || lieuxTournees.size()==0) {
			
			lieuTourneeBusiness.recupererLesLieuxEtLesTournees(masseur.getId());
			if(lieuxTournees==null || lieuxTournees.size()==0) {
				System.err.println("TODO : WARNING lieuxTournees contient toutes les tournees de tous les masseurs. masseur id="+masseur.getId());
				lieuxTournees=globalMangedBean.getLieuxTournees();
			}
		}
	
		for(LieuTournee lt:lieuxTournees) {
			
			if(lt.getTournee().getId()==tournee.getId()) {
				return lt.getLieu();
			}
		}
		
		
		return result;
	}
	
	public String getAdresseString(Tournee tournee) {
		String result = "";
		
		result += tournee.getLieuTournee().get(0).getLieu().getNom();
		result += "<br/>";
		result += tournee.getLieuTournee().get(0).getLieu().getAdresse().getLibelleAdresse();
		result += "<br/>";
		result += tournee.getLieuTournee().get(0).getLieu().getAdresse().getVille().getCodePostal();
		result += " ";
		result += tournee.getLieuTournee().get(0).getLieu().getAdresse().getVille().getLibelle();

		return result;
	}

}
