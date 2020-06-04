package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.ws.rest.service.impl.account.GenericUtilisateurServiceImpl;


@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public abstract class GenericUtilisateurWsRestConfig extends GenericUtilisateurServiceImpl {
	
	@RequestMapping(value = "/private/GenericUtilisateur/getUser", method = RequestMethod.POST)
	public GenericTransfereDataDto getUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Utilisateur ret = super.getUser();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/GenericUtilisateur/saveOrModifyUser", method = RequestMethod.POST)
	public GenericTransfereDataDto saveOrModifyUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Utilisateur ret = super.saveOrModifyUser((Utilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/GenericUtilisateur/getAllUsers", method = RequestMethod.POST)
	public GenericTransfereDataDto getAllUsers(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Utilisateur> ret = super.getAllUsers((TypeUtilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Utilisateur.class);
		return tdto;
	}

	@RequestMapping(value = "/private/GenericUtilisateur/registerUser", method = RequestMethod.POST)
	public GenericTransfereDataDto registerUser(@RequestBody GenericRequestDataDto rdto) { 

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);
		try {
			boolean ret = super.registerUser((Utilisateur) rdto.getValue());
			tdto.setValue(ret);
			tdto.setRetClass(boolean.class);
			
		}catch (Exception e) {
			tdto.setException(true);
			tdto.setExceptionMessage(e.getMessage());
		}
		return tdto;
	}

}
