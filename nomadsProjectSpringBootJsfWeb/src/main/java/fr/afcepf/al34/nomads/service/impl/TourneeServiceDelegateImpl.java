package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.dto.TournerDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.delegate.TourneeServiceDelegate;

@Service
public class TourneeServiceDelegateImpl  extends GenericDelegateImpl implements TourneeServiceDelegate  {

	
	

	@Override
	public Tournee ajouterTournee(Tournee tournee) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, tournee));
		return (Tournee) dto.getValue();
	}

	@Override
	public List<LieuTournee> recupererLaListeDesTourneesDisponible(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, id));
		return (List<LieuTournee>) dto.getValue();
	}

	@Override
	public List<Tournee> recupererLaListeDesTourneesDuMasseur(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, id));
		return (List<Tournee>) dto.getValue();
	}

	@Override
	public List<Masseur> recupererLaListeDesMasseurInscritTournees(List<Tournee> mesTournees) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericRequestDataDto rdto=new GenericRequestDataDto(baseSuburl+"/"+methodName, true, mesTournees);
		rdto.setPostClass(Tournee.class);
		
		GenericTransfereDataDto dto = callRest(rdto);
		
		return (List<Masseur>) dto.getValue();
	}

	public TournerDto ajouterTournee(TournerDto tdto) {
		
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
		
		GenericRequestDataDto rdto=new GenericRequestDataDto(baseSuburl+"/"+methodName+"tdto", true, tdto);
		rdto.setPostClass(TournerDto.class);
		
		GenericTransfereDataDto dto = callRest(rdto);
		
		
		
		return (TournerDto) dto.getValue();
	}

}
