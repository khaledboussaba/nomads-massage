package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.LieuTournee;

public interface LieuTourneeDao extends GenericDao<LieuTournee> {

	List<LieuTournee> getAllLieuAndTournees();

	List<LieuTournee> getAllLieuAndTourneesCommanditaire(Long id);

	List<LieuTournee> getAllLieuAndTournees(Long id);

	List<LieuTournee> getLieuxTourneesDisponibles();

	List<LieuTournee> getLieuxTourneesDisponibles(Long id);

	void ajouterUnLieuTournee(LieuTournee lt);
	

}
