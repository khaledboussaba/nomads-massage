package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.entities.LieuTournee;

public interface LieuTourneeService {

	List<LieuTournee> recupererLesLieuxEtLesTournees();

	void ajouterUnLieuTournee(LieuTournee lt);

	List<LieuTournee> recupererLesLieuxEtLesTourneesCommanditaire(Long id);

	List<LieuTournee> recupererLesLieuxEtLesTournees(Long id);

	List<LieuTournee> recupererLesLieuxTourneesDisponibles();

	List<LieuTournee> recupererLesLieuxTourneesDisponibles(Long id);

}
