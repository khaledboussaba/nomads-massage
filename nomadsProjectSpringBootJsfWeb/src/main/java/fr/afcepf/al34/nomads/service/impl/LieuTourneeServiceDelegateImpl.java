package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.service.delegate.LieuTourneeServiceDelegate;

@Repository
public class LieuTourneeServiceDelegateImpl  extends GenericDelegateImpl implements LieuTourneeServiceDelegate  {
	
	
	

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<LieuTournee>) dto.getValue();
	}

	@Override
	public void ajouterUnLieuTournee(LieuTournee lt) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();

		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, lt));
	}

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTourneesCommanditaire(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, id));
		return (List<LieuTournee>) dto.getValue();
	}

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName+"id", true, id));
		return (List<LieuTournee>) dto.getValue();
	}

	@Override
	public List<LieuTournee> recupererLesLieuxTourneesDisponibles() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<LieuTournee>) dto.getValue();
	}

	@Override
	public List<LieuTournee> recupererLesLieuxTourneesDisponibles(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName+"id", true, id));
		return (List<LieuTournee>) dto.getValue();
	}

}
