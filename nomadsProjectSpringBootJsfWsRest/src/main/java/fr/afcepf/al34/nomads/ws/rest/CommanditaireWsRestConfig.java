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
import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.ws.rest.service.impl.account.CommanditaireServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class CommanditaireWsRestConfig extends CommanditaireServiceImpl {

	@RequestMapping(value = "/private/Commanditaire/getUser", method = RequestMethod.POST)
	public GenericTransfereDataDto getUser(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		Commanditaire ret = super.getUser();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/saveOrModifyUser", method = RequestMethod.POST)
	public GenericTransfereDataDto saveOrModifyUser(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		Commanditaire ret = super.saveOrModifyUser((Commanditaire) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/getAllUsers", method = RequestMethod.POST)
	public GenericTransfereDataDto getAllUsers(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		List<Masseur> ret = super.getAllUsers((TypeUtilisateur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Masseur.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/registerUser", method = RequestMethod.POST)
	public GenericTransfereDataDto registerUser(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		super.registerUser((Commanditaire) rdto.getValue());
		Utilisateur ret = super.getUser();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/recupererTousLesCommanditaires", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererTousLesCommanditaires(@RequestBody GenericRequestDataDto rdto) {

		
		List<Commanditaire> ret = super.recupererTousLesCommanditaires();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Commanditaire.class);
		
		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/getError", method = RequestMethod.POST)
	public GenericTransfereDataDto getError(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		String ret = super.getError();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/setError", method = RequestMethod.POST)
	public GenericTransfereDataDto setError(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		super.setError((String) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);

		return tdto;
	}

	@RequestMapping(value = "/private/Commanditaire/recupererCommanditaire", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererCommanditaire(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		Commanditaire ret = super.recupererCommanditaire((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

}