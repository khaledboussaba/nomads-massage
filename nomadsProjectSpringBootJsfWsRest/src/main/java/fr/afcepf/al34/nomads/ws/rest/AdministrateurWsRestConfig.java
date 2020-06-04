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
import fr.afcepf.al34.nomads.entities.Administrateur;
import fr.afcepf.al34.nomads.ws.rest.service.impl.account.AdministrateurServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class AdministrateurWsRestConfig extends AdministrateurServiceImpl {

	@RequestMapping(value = "/private/Administrateur/getUser", method = RequestMethod.POST)
	public GenericTransfereDataDto getUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Administrateur ret = super.getUser();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Administrateur/saveOrModifyUser", method = RequestMethod.POST)
	public GenericTransfereDataDto saveOrModifyUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Administrateur utilisateur = super.saveOrModifyUser((Administrateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, utilisateur);
		tdto.setRetClass(utilisateur.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Administrateur/getAllUsers", method = RequestMethod.POST)
	public GenericTransfereDataDto getAllUsers(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Administrateur> ret = super.getAllUsers((TypeUtilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Administrateur.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Administrateur/registerUser", method = RequestMethod.POST)
	public GenericTransfereDataDto registerUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		boolean ret = super.registerUser((Administrateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(boolean.class);
		return tdto;
	}

}