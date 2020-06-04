package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.ws.rest.service.impl.MasseurTourneeServiceImpl;


@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class MasseurTourneeWsRestConfig extends MasseurTourneeServiceImpl {

	@RequestMapping(value = "/private/MasseurTournee/recupererLaListeDesMasseursTournee", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesMasseursTournee(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<MasseurTournee> ret = super.recupererLaListeDesMasseursTournee((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(MasseurTournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/MasseurTournee/ajouterUnMasseurTournee", method = RequestMethod.POST)
	public GenericTransfereDataDto ajouterUnMasseurTournee(@RequestBody GenericRequestDataDto rdto) {
		MasseurTournee ret = new MasseurTournee();
		System.out.println("rdto.getValue()"+rdto.getValue());
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		System.out.println("(MasseurTournee) rdto.getValue()"+(MasseurTournee) rdto.getValue());
		
		//MasseurTournee ret = super.ajouterUnMasseurTournee((MasseurTournee) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}
	
}
