package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.dto.TournerDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface TourneeBusiness {

	Tournee ajouterTournee(Tournee tournee);

	List<LieuTournee> recupererLaListeDesTourneesDisponible(Long id);

	List<Tournee> recupererLaListeDesTourneesDuMasseur(Long id);

	List<Masseur> recupererLaListeDesMasseurInscritTournees(List<Tournee> mesTournees);

	TournerDto ajouterTournee(TournerDto tdto);

}
