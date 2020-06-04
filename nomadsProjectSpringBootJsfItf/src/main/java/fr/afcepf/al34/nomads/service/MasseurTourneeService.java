package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.entities.MasseurTournee;

public interface MasseurTourneeService {

	List<MasseurTournee> recupererLaListeDesMasseursTournee(Long id);

	MasseurTournee ajouterUnMasseurTournee(MasseurTournee mt);

}
