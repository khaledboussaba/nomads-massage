package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.MasseurTournee;

public interface MasseurTourneeServiceDelegate {

	List<MasseurTournee> recupererLaListeDesMasseursTournee(Long id);

	MasseurTournee ajouterUnMasseurTournee(MasseurTournee mt);

}
