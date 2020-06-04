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
import fr.afcepf.al34.nomads.ws.rest.service.impl.LieuTourneeServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class LieuTourneeWsRestConfig extends LieuTourneeServiceImpl {

	@RequestMapping(value = "/private/LieuTournee/recupererLesLieuxEtLesTournees", method = RequestMethod.POST)
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

	@RequestMapping(value = "/private/LieuTournee/ajouterUnLieuTournee", method = RequestMethod.POST)
	public GenericTransfereDataDto ajouterUnLieuTournee(@RequestBody GenericRequestDataDto rdto) {


		
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		super.ajouterUnLieuTournee((LieuTournee) rdto.getValue());
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);
		return tdto;
	}

	@RequestMapping(value = "/private/LieuTournee/recupererLesLieuxEtLesTourneesCommanditaire", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLesLieuxEtLesTourneesCommanditaire(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<LieuTournee> ret = super.recupererLesLieuxEtLesTourneesCommanditaire((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(LieuTournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/LieuTournee/recupererLesLieuxEtLesTourneesid", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLesLieuxEtLesTourneesLong(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<LieuTournee> ret = super.recupererLesLieuxEtLesTournees((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(LieuTournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/LieuTournee/recupererLesLieuxTourneesDisponibles", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLesLieuxTourneesDisponibles(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<LieuTournee> ret = super.recupererLesLieuxTourneesDisponibles();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(LieuTournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/LieuTournee/recupererLesLieuxTourneesDisponiblesid", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLesLieuxTourneesDisponiblesLong(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
//		System.out.println("SASA id="+rdto.getValue());
		
		List<LieuTournee> ret = super.recupererLesLieuxTourneesDisponibles((Long) rdto.getValue());
		
//		System.out.println("SASA ret="+ret);
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(LieuTournee.class);
		return tdto;
	}

}
