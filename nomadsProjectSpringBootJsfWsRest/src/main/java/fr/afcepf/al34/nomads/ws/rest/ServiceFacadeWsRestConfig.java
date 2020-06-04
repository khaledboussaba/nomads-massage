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
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.ws.rest.service.impl.ServiceFacadeImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class ServiceFacadeWsRestConfig extends ServiceFacadeImpl {
	

	@RequestMapping(value = "/private/ServiceFacade/getUser", method = RequestMethod.POST)
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
	
	@RequestMapping(value = "/private/ServiceFacade/getService", method = RequestMethod.POST)
	public GenericTransfereDataDto getService(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Object ret = super.getService((TypeUtilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/ServiceFacade/getUsers", method = RequestMethod.POST)
	public GenericTransfereDataDto getUsers(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Utilisateur> ret = super.getUsers((TypeUtilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Utilisateur.class);
		return tdto;
	}
	
	@RequestMapping(value = "/private/ServiceFacade/connexionUtilisateur", method = RequestMethod.POST)
	public GenericTransfereDataDto connexionUtilisateur(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		String ret = super.connexionUtilisateur();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/ServiceFacade/getTournees", method = RequestMethod.POST)
	public GenericTransfereDataDto getTournees(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Tournee> ret = super.getTournees((String) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Tournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/ServiceFacade/registerUser", method = RequestMethod.POST)
	public GenericTransfereDataDto registerUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		boolean ret = super.registerUser((TypeUtilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(boolean.class);
		return tdto;
	}

}
