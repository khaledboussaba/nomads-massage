package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.service.delegate.MasseurTourneeServiceDelegate;

@Service
public class MasseurTourneeServiceDelegateImpl  extends GenericDelegateImpl implements MasseurTourneeServiceDelegate  {

	
	

	@Override
	public List<MasseurTournee> recupererLaListeDesMasseursTournee(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, id));
		return (List<MasseurTournee>) dto.getValue();
	}

	@Override
	public MasseurTournee ajouterUnMasseurTournee(MasseurTournee mt) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, mt));
		return (MasseurTournee) dto.getValue();
	}

}
