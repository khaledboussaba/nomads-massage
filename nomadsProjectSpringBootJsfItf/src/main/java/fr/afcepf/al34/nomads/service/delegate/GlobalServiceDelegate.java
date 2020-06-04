package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.entities.LieuTournee;

public interface GlobalServiceDelegate {
	/**
	 * Author Sami
	 */
	

	List<LieuTournee> recupererLesLieuxEtLesTournees();
}
