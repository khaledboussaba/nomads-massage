package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.LieuTournee;

public interface GlobalBusiness {
	/**
	 * Author Sami
	 */
	

	List<LieuTournee> recupererLesLieuxEtLesTournees();
}
