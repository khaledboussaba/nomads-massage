package fr.afcepf.al34.nomads.ws.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.ws.rest.service.impl.LigneCommandeServiceImpl;


@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class LigneCommandeWsRestConfig extends LigneCommandeServiceImpl {
	
	@RequestMapping(value = "/private/LigneCommande/enregisterLigneCommande", method = RequestMethod.POST)
	public GenericTransfereDataDto enregisterLigneCommande(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		super.enregisterLigneCommande((LigneCommande) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);
		return tdto;
	}

	@RequestMapping(value = "/private/LigneCommande/recupererLeNombreDeCreditAcrediter", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeCreditAcrediter(@RequestBody GenericRequestDataDto rdto) {

		System.out.println("rdto.getValue()="+rdto.getValue());
		System.out.println("rdto.getPostClass()="+rdto.getPostClass());
		
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		
		Long ret = super.recupererLeNombreDeCreditAcrediter((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

}
