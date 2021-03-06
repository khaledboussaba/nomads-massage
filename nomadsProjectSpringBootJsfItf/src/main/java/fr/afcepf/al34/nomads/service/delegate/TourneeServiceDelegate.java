package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface TourneeServiceDelegate {

	Tournee ajouterTournee(Tournee tournee);

	List<LieuTournee> recupererLaListeDesTourneesDisponible(Long id);

	List<Tournee> recupererLaListeDesTourneesDuMasseur(Long id);

	List<Masseur> recupererLaListeDesMasseurInscritTournees(List<Tournee> mesTournees);

}
