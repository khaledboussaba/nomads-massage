package fr.afcepf.al34.nomads.ws.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.ws.rest.service.impl.CommandeServiceImpl;


@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class CommandeWsRestConfig extends CommandeServiceImpl {

	@RequestMapping(value = "/private/Commande/enregisterCommande", method = RequestMethod.POST)
	public GenericTransfereDataDto enregisterCommande(@RequestBody GenericRequestDataDto rdto) {

		System.out.println("rdto.getValue()="+rdto.getValue());
		System.out.println("rdto.getPostClass()="+rdto.getPostClass());
		
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		System.out.println("rdto.getValue()="+rdto.getValue());
		
		
		Commande ret = super.enregisterCommande((Commande) rdto.getValue());
		System.out.println("ret="+ret);
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

}
