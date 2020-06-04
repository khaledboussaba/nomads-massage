package fr.afcepf.al34.nomads.business.impl.account;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.business.MasseurBusiness;
import fr.afcepf.al34.nomads.dto.CommandeDto;
import fr.afcepf.al34.nomads.dto.TournerBuyDto;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.service.impl.account.MasseurServiceDelegateImpl;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Service
@Getter @Setter @NoArgsConstructor
public class MasseurBusinessImpl extends MasseurServiceDelegateImpl implements MasseurBusiness  {

	private Masseur utilisateur;

	public Masseur getUser() {
		return utilisateur;
	}

	public Masseur saveOrModifyUser(Masseur utilisateur) {
		utilisateur = super.saveOrModifyUser(utilisateur);
		this.utilisateur=utilisateur;
		return utilisateur;
	}

	public List<Masseur> getAllUsers(TypeUtilisateur type) {
		
		return super.getAllUsers(type);
	}

	public boolean userNotExisting(String login) {
		return super.userNotExisting(login);
	}
	
	/*
	 * Author Sami
	 */
	public boolean registerUser(Masseur utilisateur) {
		boolean success=super.registerUser(utilisateur);
		this.utilisateur=utilisateur;
		return success;
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public List<Masseur> recupererTousLesMasseur() {
		return super.recupererTousLesMasseur();
	}

	/*
	 * @author: Khaled
	 */
	@Override
	public Masseur recupererLeMasseur(Long id) {
		return super.recupererLeMasseur(id);
	}
	/*
	 * @author: Khaled
	 */
	@Override
	public Masseur mettreAjourMasseur(Masseur masseur) {
		return super.mettreAjourMasseur(masseur);
	}

	@Override
	public TournerBuyDto buyTournee(TournerBuyDto tbdto) {
		return super.buyTournee(tbdto);
	}

	@Override
	public CommandeDto enregistrerCommande(CommandeDto cdto) {
		return super.enregistrerCommande(cdto);
	}
	
}