package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.LieuTournee;

public interface GlobalService {
	/**
	 * Author Sami
	 */
	

	List<LieuTournee> recupererLesLieuxEtLesTournees();
}
