package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.MasseurTourneeBusiness;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.service.impl.MasseurTourneeServiceDelegateImpl;

@Service
public class MasseurTourneeBusinessImpl extends MasseurTourneeServiceDelegateImpl implements MasseurTourneeBusiness {

	@Override
	public List<MasseurTournee> recupererLaListeDesMasseursTournee(Long id) {
		return super.recupererLaListeDesMasseursTournee(id);
	}

	@Override
	public MasseurTournee ajouterUnMasseurTournee(MasseurTournee mt) {
		return super.ajouterUnMasseurTournee(mt);
	}
	
	

}
