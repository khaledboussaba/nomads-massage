package fr.afcepf.al34.nomads.service.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.service.delegate.CommandeServiceDelegate;

@Service
public class CommandeServiceDelegateImpl  extends GenericDelegateImpl implements CommandeServiceDelegate  {
	
	
	

	@Override
	public Commande enregisterCommande(Commande commandeASauvegarder) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, commandeASauvegarder));
		return (Commande) dto.getValue();
	}

}
