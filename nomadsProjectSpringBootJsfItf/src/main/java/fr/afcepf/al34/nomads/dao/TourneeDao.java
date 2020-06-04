package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;

public interface TourneeDao extends GenericDao<Tournee> {

	List<LieuTournee> getAllTourneesDispo(Long id);

	List<Tournee> getTourneesMasseur(Long id);

	List<Masseur> getTourneesMasseur(List<Tournee> tournees);

}
