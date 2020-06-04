package fr.afcepf.al34.nomads.ws.rest.service.impl.account;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dao.CredentialsDao;
import fr.afcepf.al34.nomads.dao.MasseurDao;
import fr.afcepf.al34.nomads.dto.CommandeDto;
import fr.afcepf.al34.nomads.dto.LigneCommandeDto;
import fr.afcepf.al34.nomads.dto.TournerBuyDto;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.CommandeService;
import fr.afcepf.al34.nomads.service.LigneCommandeService;
import fr.afcepf.al34.nomads.service.LoginService;
import fr.afcepf.al34.nomads.service.MasseurService;
import fr.afcepf.al34.nomads.service.MasseurTourneeService;
import fr.afcepf.al34.nomads.ws.rest.service.impl.authenticator.AuthenticationManagerRest;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Service
@Getter
@Setter
@NoArgsConstructor
@Transactional
public class MasseurServiceImpl implements MasseurService {

	@Autowired
	protected MasseurDao utilisateurDao;

	@Autowired
	private CredentialsDao credentialsDao;

	@Autowired
	@Qualifier("loginServiceImpl")
	private LoginService loginService;

	@Autowired
	@Qualifier("masseurTourneeServiceImpl")
	private MasseurTourneeService masseurTourneeService;

	@Autowired
	@Qualifier("ligneCommandeServiceImpl")
	private LigneCommandeService lcBusiness;

	@Autowired
	@Qualifier("commandeServiceImpl")
	private CommandeService cBusiness;

	private Masseur utilisateur;

	public Masseur getUser() {
		return utilisateur;
	}

	public Masseur saveOrModifyUser(Masseur utilisateur) {
		utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
		return utilisateur;
	}

	public List<Masseur> getAllUsers(TypeUtilisateur type) {
		if (type != TypeUtilisateur.MASSEUR) {
			// TODO login error
			return new ArrayList<Masseur>();
		}
		return (List<Masseur>) utilisateurDao.getAllUtilisateurs();
	}

	public boolean userNotExisting(String login) {
		return utilisateurDao.loginNoExist(login);
	}

	/*
	 * Author Sami
	 */
	public boolean registerUser(Masseur utilisateur) {
		boolean success = false;
		if (loginService.userNotExisting(utilisateur.getCredentials().getLogin())) {
			success = true;

			try {
				AuthenticationManagerRest.initialiseCredentials(utilisateur.getCredentials().getClearPassword(),
						utilisateur.getCredentials());
			} catch (Exception e1) {
				System.out.println("Probleme de generation de hash : " + e1.getMessage());
				return false;
			}

			utilisateur = utilisateurDao.sauvegarderUtilisateur(utilisateur);
			if (utilisateur == null || ((Utilisateur) utilisateur).getId() == null) {
				success = false;
			} else {
				try {
					success = loginService.userLogin(utilisateur);
				} catch (Exception e) {
					success = false;
					if (e.getMessage() == null) {
						e.printStackTrace();
					}
					System.out.println("le login n'a pas fonctionne : " + e.getMessage());
				}
			}
		} else {
			System.out.println(utilisateur.getCredentials().getLogin() + " is in database");
		}
		return success;
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public List<Masseur> recupererTousLesMasseur() {
		return utilisateurDao.getAllMasseurs();
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public Masseur recupererLeMasseur(Long id) {
		return utilisateurDao.findById(id);
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public Masseur mettreAjourMasseur(Masseur masseur) {
		return utilisateurDao.update(masseur);
	}

	public TournerBuyDto buyTournee(TournerBuyDto tbdto) {

		List<MasseurTournee> masseurTournees = tbdto.getMasseurTournees();
		Tournee tournee = tbdto.getTournee();
		Masseur masseur = tbdto.getMasseur();
		masseur.setPorteMonnaie(masseur.getPorteMonnaie() - tournee.getPrixCredit());

		MasseurTournee masseurTournee = new MasseurTournee();

		masseurTournee.setMasseur(masseur);
		masseurTournee.setTournee(tournee);
		masseurTournees.add(masseurTournee);

		masseurTournee = masseurTourneeService.ajouterUnMasseurTournee(masseurTournee);

		masseur = updateCreditMasseur(masseur);

		tbdto.setMasseur(masseur);
		tbdto.setTournee(tournee);
		tbdto.setMasseurTournees(masseurTournees);

		return tbdto;
	}

	private Masseur updateCreditMasseur(Masseur masseur) {
		masseur.setPorteMonnaie(utilisateurDao.updateCreditMasseur(masseur.getId(), masseur.getPorteMonnaie()));
		return masseur;
	}

	
	public CommandeDto enregistrerCommande(CommandeDto rdto) {
		Masseur masseur = recupererLeMasseur(rdto.getMasseurId());
		Commande commandeASauvegarder = new Commande();
		commandeASauvegarder.setDate(rdto.getDate());
		commandeASauvegarder.setMasseur(masseur);

		List<LigneCommandeDto> lignesDto = rdto.getLignes();
		List<LigneCommande> lignes = new ArrayList<LigneCommande>();

		for (LigneCommandeDto ligneDto : lignesDto) {
			LigneCommande ligne = new LigneCommande(ligneDto);
			lignes.add(ligne);
		}

		commandeASauvegarder.setLigneCommandes(lignes);
		commandeASauvegarder = cBusiness.enregisterCommande(commandeASauvegarder);

		Long nbCreditsAcrediter = 0L; 
										
		for (LigneCommande ligneCommande : lignes) {
			System.out.println("KHAKHA="+commandeASauvegarder.getId());
			ligneCommande.setCommande(commandeASauvegarder);
			
			if (ligneCommande.getProduit() instanceof PackCredit) {
				nbCreditsAcrediter += ((PackCredit) ligneCommande.getProduit()).getNombreCredit();
			}
		}

		masseur.setPorteMonnaie(masseur.getPorteMonnaie() + nbCreditsAcrediter);
		masseur = mettreAjourMasseur(masseur);

		rdto.setIdCommande(commandeASauvegarder.getId());
		return rdto;
	}

}