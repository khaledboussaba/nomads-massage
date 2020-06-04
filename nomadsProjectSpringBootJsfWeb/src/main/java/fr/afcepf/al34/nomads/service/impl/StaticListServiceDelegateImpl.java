package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.service.delegate.StaticListServiceDelegate;
@Service
public class StaticListServiceDelegateImpl  extends GenericDelegateImpl implements StaticListServiceDelegate  {

	
	

	@Override
	public List<Titre> getListTitre() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Titre>) dto.getValue();
	}

	@Override
	public List<String> getListCodePostaux() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<String>) dto.getValue();
	}

	@Override
	public List<String> getListVille() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<String>) dto.getValue();
	}
	
}
