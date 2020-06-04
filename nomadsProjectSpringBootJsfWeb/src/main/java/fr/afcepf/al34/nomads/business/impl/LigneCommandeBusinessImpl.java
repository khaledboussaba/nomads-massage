package fr.afcepf.al34.nomads.business.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.LigneCommandeBusiness;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.service.impl.LigneCommandeServiceDelegateImpl;

@Service
public class LigneCommandeBusinessImpl extends LigneCommandeServiceDelegateImpl implements LigneCommandeBusiness {
	
	@Override
	public void enregisterLigneCommande(LigneCommande ligneCommande) {
		
		super.enregisterLigneCommande(ligneCommande);
	}

	@Override
	public Long recupererLeNombreDeCreditAcrediter(Long id) {
		return super.recupererLeNombreDeCreditAcrediter(id);
	}

}
