package fr.afcepf.al34.nomads.service.impl.account;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.service.delegate.AdministrateurServiceDelegate;
import fr.afcepf.al34.nomads.service.impl.GenericDelegateImpl;
import fr.afcepf.al34.nomads.service.impl.UtilisateurServiceDelegateImpl;
@Service
public class AdministrateurServiceDelegateImpl  extends GenericDelegateImpl implements AdministrateurServiceDelegate  {

	
	

	public Administrateur getUser() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (Administrateur) dto.getValue();
	}

	public Administrateur saveOrModifyUser(Administrateur utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (Administrateur) dto.getValue();
	}

	public List<Administrateur> getAllUsers(TypeUtilisateur type) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, type));
		return (List<Administrateur>) dto.getValue();
	}

	public boolean registerUser(Administrateur utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (boolean) dto.getValue();
	}
	
}