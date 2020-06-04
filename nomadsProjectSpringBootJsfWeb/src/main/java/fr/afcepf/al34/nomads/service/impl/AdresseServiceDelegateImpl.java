package fr.afcepf.al34.nomads.service.impl;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.service.delegate.AdresseServiceDelegate;

@Service
public class AdresseServiceDelegateImpl  extends GenericDelegateImpl implements AdresseServiceDelegate  {

	@Override
	public Adresse ajouterUneNouvelleAdresse(Adresse adresse) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, adresse));
		return (Adresse) dto.getValue();
	}

}
