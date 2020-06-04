package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import lombok.Getter;
import lombok.Setter;


@Service
@Getter @Setter
public class ServiceDelegateImplFacadeImpl  extends GenericDelegateImpl implements BusinessFacade {
	
	
	
	

	@Override
	public Utilisateur getUser() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Utilisateur) dto.getValue();
	}
	
	public <T> T getBusiness(TypeUtilisateur userType) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, userType));
		return (T) dto.getValue();
	}

	@Override
	public List<Utilisateur> getUsers(TypeUtilisateur userType) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, userType));
		return (List<Utilisateur>) dto.getValue();
	}

	
	
	@Override
	public String connexionUtilisateur() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (String) dto.getValue();
	}

	@Override
	public List<Tournee> getTournees(String action) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, action));
		return (List<Tournee>) dto.getValue();
	}

	@Override
	public boolean registerUser(TypeUtilisateur userType) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, userType));
		return (boolean) dto.getValue();
	}

}
