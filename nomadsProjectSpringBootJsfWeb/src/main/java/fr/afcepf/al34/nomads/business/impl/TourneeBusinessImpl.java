package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.TourneeBusiness;
import fr.afcepf.al34.nomads.dto.TournerDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.impl.TourneeServiceDelegateImpl;

@Service
public class TourneeBusinessImpl extends TourneeServiceDelegateImpl implements TourneeBusiness {

	@Override
	public Tournee ajouterTournee(Tournee tournee) {
		tournee.setPrixCredit(1L);
		return super.ajouterTournee(tournee);
	}

	@Override
	public List<LieuTournee> recupererLaListeDesTourneesDisponible(Long id) {
		return super.recupererLaListeDesTourneesDisponible(id);
	}

	@Override
	public List<Tournee> recupererLaListeDesTourneesDuMasseur(Long id) {
		return super.recupererLaListeDesTourneesDuMasseur(id);
	}

	@Override
	public List<Masseur> recupererLaListeDesMasseurInscritTournees(List<Tournee> mesTournees) {
		return super.recupererLaListeDesMasseurInscritTournees(mesTournees);
	}

	@Override
	public TournerDto ajouterTournee(TournerDto tdto) {
		return super.ajouterTournee(tdto);
	}

}
