package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.ws.rest.service.impl.GlobalServiceImpl;


@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class GlobalWsRestConfig extends GlobalServiceImpl {

	@RequestMapping(value = "/private/Global/recupererLesLieuxEtLesTournees", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLesLieuxEtLesTournees(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<LieuTournee> ret = super.recupererLesLieuxEtLesTournees();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		
		tdto.setRetClass(LieuTournee.class);
		return tdto;
	}

}
