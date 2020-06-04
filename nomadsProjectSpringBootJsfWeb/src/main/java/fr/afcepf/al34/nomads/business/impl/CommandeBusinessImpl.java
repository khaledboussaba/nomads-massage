package fr.afcepf.al34.nomads.business.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.CommandeBusiness;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.service.impl.CommandeServiceDelegateImpl;

@Service
public class CommandeBusinessImpl extends CommandeServiceDelegateImpl implements CommandeBusiness {
	
	@Override
	public Commande enregisterCommande(Commande commandeASauvegarder) {
		return super.enregisterCommande(commandeASauvegarder);	
	}

}
