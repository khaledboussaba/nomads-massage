package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.CommanditaireBusiness;
import fr.afcepf.al34.nomads.business.LieuBusiness;
import fr.afcepf.al34.nomads.business.LieuTourneeBusiness;
import fr.afcepf.al34.nomads.business.TourneeBusiness;
import fr.afcepf.al34.nomads.dto.TournerDto;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.StatutLieu;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Type;
import fr.afcepf.al34.nomads.entities.Ville;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean(value = "mbCommanditaire")
@SessionScope
@Getter @Setter @NoArgsConstructor 
public class CommanditaireMangedBean implements Serializable {
	private static final long serialVersionUID = -6180907226425729452L;

	@Autowired
	private CommanditaireBusiness commanditaireBusiness;
	@Autowired
	private LieuBusiness lieuBusiness;
	@Autowired
	private LieuTourneeBusiness lieuTourneeBusiness;
	@Autowired
	private TourneeBusiness tourneeBusiness;

	@Autowired 
	private LoginManagedBean mbLogin;
	
	
	
	private Commanditaire commanditaire;
	private List<Lieu> lieux;
	private List<Lieu> lieuxActif;
	private List<LieuTournee> lieuxTournnees;
	
	private Lieu lieuSelected;
	private Date date;
	private Date heureDebut;
	private Date heureFin;
	
	private Lieu nouveauLlieu = new Lieu();
	
	private Tournee tournee = new Tournee();
	
	private Adresse adresse = new Adresse();
	private Ville ville = new Ville();
	
	@PostConstruct
	public void init() {
		Date todayDebut=new Date();
		todayDebut.setHours(20);
		todayDebut.setMinutes(0);
		Date todayFin=new Date();
		todayFin.setHours(23);
		todayFin.setMinutes(0);
		Date today=new Date();
		
		tournee.setHeureDebut(todayDebut);
		tournee.setHeureFin(todayFin);
		tournee.setDate(today);
		
		
		//System.out.println("mbLogin.getUtilisateur().getId()"+mbLogin.getUtilisateur().getId());
		if(mbLogin.getUtilisateur().getId()==null) {
			commanditaire = commanditaireBusiness.recupererCommanditaire(mbLogin.getRegisterCommanditaireManagedBean().getUtilisateur().getId());
		}else {
			commanditaire = commanditaireBusiness.recupererCommanditaire(mbLogin.getUtilisateur().getId());
		}
		lieux = lieuBusiness.recupererLieuxCommanditaire(commanditaire.getId());
		
		lieuxActif = lieuBusiness.recupererLieuxActifCommanditaire(commanditaire.getId());
		lieuxTournnees = lieuTourneeBusiness.recupererLesLieuxEtLesTourneesCommanditaire(commanditaire.getId());
		
	}
	
	public String ajouterTournee() {
		
		TournerDto tdto=new TournerDto(tournee, lieuSelected,commanditaire.getId());
		tdto=tourneeBusiness.ajouterTournee(tdto);
		/*tournee = tourneeBusiness.ajouterTournee(tournee);
		
		LieuTournee lt = new LieuTournee();
		lt.setLieu(lieuSelected);
		lt.setTournee(tournee);
		lieuTourneeBusiness.ajouterUnLieuTournee(lt);
		
		
		
		
		lieuxTournnees = lieuTourneeBusiness.recupererLesLieuxEtLesTourneesCommanditaire(commanditaire.getId());
		tournee = new Tournee();
		*/
		
		return "/commanditaire/accueilCommanditaire.xhtml?faces-redirect=true";
	}
	
	public String ajouterLieu() {
		StatutLieu sl = new StatutLieu();
		sl.setId(1l);
		nouveauLlieu.setStatut(sl);
		Type type = new Type();
		type.setId(1l);
		nouveauLlieu.setType(type);
		
		nouveauLlieu.setCommanditaire(commanditaire);
		adresse.setVille(ville);
		nouveauLlieu.setAdresse(adresse);
		nouveauLlieu = lieuBusiness.ajouterUnNouveauLieu(nouveauLlieu);
		lieux = lieuBusiness.recupererLieuxCommanditaire(commanditaire.getId());
		lieuxActif = lieuBusiness.recupererLieuxActifCommanditaire(commanditaire.getId());
		adresse = new Adresse();
		ville = new Ville();
		nouveauLlieu = new Lieu();
		return "/commanditaire/accueilCommanditaire.xhtml?faces-redirect=true";
	}

}
