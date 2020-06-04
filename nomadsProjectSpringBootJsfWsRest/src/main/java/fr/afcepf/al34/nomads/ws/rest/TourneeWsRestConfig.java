package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.dto.TournerDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.ws.rest.service.impl.TourneeServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class TourneeWsRestConfig extends TourneeServiceImpl {

	@RequestMapping(value = "/private/Tournee/ajouterTournee", method = RequestMethod.POST)
	public GenericTransfereDataDto ajouterTournee(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Tournee ret = super.ajouterTournee((Tournee) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}
	
	@RequestMapping(value = "/private/Tournee/ajouterTourneetdto", method = RequestMethod.POST)
	public GenericTransfereDataDto ajouterTourneetdto(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		TournerDto ret = super.ajouterTournee((TournerDto) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Tournee/recupererLaListeDesTourneesDisponible", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesTourneesDisponible(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<LieuTournee> ret = super.recupererLaListeDesTourneesDisponible((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(LieuTournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Tournee/recupererLaListeDesTourneesDuMasseur", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesTourneesDuMasseur(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		List<Tournee> ret = super.recupererLaListeDesTourneesDuMasseur((Long) rdto.getValue());
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Tournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Tournee/recupererLaListeDesMasseurInscritTournees", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesMasseurInscritTournees(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			ObjectMapper jsonMapper = new ObjectMapper();
			JavaType type = jsonMapper.getTypeFactory().constructCollectionType(List.class, rdto.getPostClass());
			rdto.setValue(jsonMapper.convertValue(rdto.getValue(), type));
		}

		@SuppressWarnings("unchecked")
		List<Masseur> ret = super.recupererLaListeDesMasseurInscritTournees((List<Tournee>) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Masseur.class);
		return tdto;
	}

}
