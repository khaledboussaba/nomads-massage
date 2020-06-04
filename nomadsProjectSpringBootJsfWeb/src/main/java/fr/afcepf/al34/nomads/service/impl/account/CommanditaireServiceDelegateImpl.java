package fr.afcepf.al34.nomads.service.impl.account;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.service.delegate.CommanditaireServiceDelegate;
import fr.afcepf.al34.nomads.service.impl.GenericDelegateImpl;
import fr.afcepf.al34.nomads.service.impl.UtilisateurServiceDelegateImpl;
@Service
public class CommanditaireServiceDelegateImpl  extends GenericDelegateImpl implements CommanditaireServiceDelegate  {

	
	

	public Commanditaire saveOrModifyUser(Commanditaire utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (Commanditaire) dto.getValue();
	}

	public List<Masseur> getAllUsers(TypeUtilisateur type) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, type));
		return (List<Masseur>) dto.getValue();
	}

	public Commanditaire registerUser(Commanditaire utilisateur) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, utilisateur));
		return (Commanditaire) dto.getValue();
	}

	/* 
	 * @Author : Khaled
	 */
	@Override
	public List<Commanditaire> recupererTousLesCommanditaires() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, true, null));
		return (List<Commanditaire>) dto.getValue();
	}

	public String getError() {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, null));
		return (String) dto.getValue();
	}

	public void setError(String error) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, error));
//		return () dto.getValue();
	}

	@Override
	public Commanditaire recupererCommanditaire(Long id) {
		Exception e = new Exception();
		e.fillInStackTrace();
		String methodName = e.getStackTrace()[0].getMethodName();
	
		GenericTransfereDataDto dto = callRest(new GenericRequestDataDto(baseSuburl+"/"+methodName, false, id));
		return (Commanditaire) dto.getValue();
	}
	
}