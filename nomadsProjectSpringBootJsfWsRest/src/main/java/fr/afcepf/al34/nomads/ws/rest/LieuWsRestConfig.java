package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.ws.rest.service.impl.LieuServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class LieuWsRestConfig extends LieuServiceImpl {

	@RequestMapping(value = "/private/Lieu/recupererLieuParSonId", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLieuParSonId(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Lieu ret = super.recupererLieuParSonId((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@Transactional
	@RequestMapping(value = "/private/Lieu/mettreAjourLieu", method = RequestMethod.POST)
	public GenericTransfereDataDto mettreAjourLieu(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Lieu ret = super.mettreAjourLieu((Lieu) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}


	@RequestMapping(value = "/private/Lieu/recupererLieuxCommanditaire", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLieuxCommanditaire(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		List<Lieu> ret = super.recupererLieuxCommanditaire((Long) rdto.getValue());
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Lieu.class);
		return tdto;
	}

	@Transactional
	@RequestMapping(value = "/private/Lieu/ajouterUnNouveauLieu", method = RequestMethod.POST)
	public GenericTransfereDataDto ajouterUnNouveauLieu(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Lieu ret = super.ajouterUnNouveauLieu((Lieu) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Lieu/recupererLieuxActifCommanditaire", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLieuxActifCommanditaire(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Lieu> ret = super.recupererLieuxActifCommanditaire((Long) rdto.getValue());
		
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Lieu.class);
		return tdto;
	}

}
