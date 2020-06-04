package fr.afcepf.al34.nomads.business.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.AdresseBusiness;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.service.impl.AdresseServiceDelegateImpl;

@Service
public class AdresseBusinessImpl extends AdresseServiceDelegateImpl implements AdresseBusiness {

	@Override
	public Adresse ajouterUneNouvelleAdresse(Adresse adresse) {
		return super.ajouterUneNouvelleAdresse(adresse);
	}

}
