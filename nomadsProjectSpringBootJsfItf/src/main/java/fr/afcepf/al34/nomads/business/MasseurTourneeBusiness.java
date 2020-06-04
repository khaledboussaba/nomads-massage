package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.entities.MasseurTournee;

public interface MasseurTourneeBusiness {

	List<MasseurTournee> recupererLaListeDesMasseursTournee(Long id);

	MasseurTournee ajouterUnMasseurTournee(MasseurTournee mt);

}
