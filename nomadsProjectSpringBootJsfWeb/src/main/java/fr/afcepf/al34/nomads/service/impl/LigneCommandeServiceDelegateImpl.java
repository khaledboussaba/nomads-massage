package fr.afcepf.al34.nomads.service.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.service.delegate.LigneCommandeServiceDelegate;

@Service
public class LigneCommandeServiceDelegateImpl  extends GenericDelegateImpl implements LigneCommandeServiceDelegate  {
	
	
	

	@Override
	public void enregisterLigneCommande(LigneCommande ligneCommande) {
		
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, ligneCommande));
//		return () dto.getValue();
	}

	@Override
	public Long recupererLeNombreDeCreditAcrediter(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, id));
		return (Long) dto.getValue();
	}

}
