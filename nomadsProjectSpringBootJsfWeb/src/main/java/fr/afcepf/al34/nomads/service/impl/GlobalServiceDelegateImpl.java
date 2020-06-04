package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.service.delegate.GlobalServiceDelegate;

@Service
public class GlobalServiceDelegateImpl  extends GenericDelegateImpl implements GlobalServiceDelegate  {

	
	

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		
		return (List<LieuTournee>) dto.getValue();
	}
}
