package fr.afcepf.al34.nomads.service.impl.account;

import java.util.List;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.delegate.UtilisateurServiceDelegate;
import fr.afcepf.al34.nomads.service.impl.GenericDelegateImpl;
import fr.afcepf.al34.nomads.service.impl.UtilisateurServiceDelegateImpl;

public abstract class GenericUtilisateurServiceDelegateImpl  extends GenericDelegateImpl implements UtilisateurServiceDelegate  {

	
	

	@Override
	public Utilisateur saveOrModifyUser(Utilisateur utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (Utilisateur) dto.getValue();
	}

	@Override
	public List<Utilisateur> getAllUsers(TypeUtilisateur type) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, type));
		return (List<Utilisateur>) dto.getValue();
	}

	@Override 
	public boolean registerUser(Utilisateur utilisateur) throws Exception {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (boolean) dto.getValue();
	}

}
