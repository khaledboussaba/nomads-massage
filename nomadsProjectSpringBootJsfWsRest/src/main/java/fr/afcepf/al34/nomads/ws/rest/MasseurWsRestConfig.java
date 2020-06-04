package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.business.BusinessFacade.TypeUtilisateur;
import fr.afcepf.al34.nomads.dto.CommandeDto;
import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.dto.TournerBuyDto;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.ws.rest.service.impl.account.MasseurServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class MasseurWsRestConfig extends MasseurServiceImpl {

	@RequestMapping(value = "/private/Masseur/getUser", method = RequestMethod.POST)
	public GenericTransfereDataDto getUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Masseur ret = super.getUser();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Masseur/saveOrModifyUser", method = RequestMethod.POST)
	public GenericTransfereDataDto saveOrModifyUser(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Masseur ret = super.saveOrModifyUser((Masseur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Masseur/getAllUsers", method = RequestMethod.POST)
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

	@RequestMapping(value = "/private/Masseur/userNotExisting", method = RequestMethod.POST)
	public GenericTransfereDataDto userNotExisting(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		boolean ret = super.userNotExisting((String) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(boolean.class);
		return tdto;
	}
	
	/*
	 * Author Sami
	 */
	@RequestMapping(value = "/private/Masseur/registerUser", method = RequestMethod.POST)
	public GenericTransfereDataDto registerUser(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		boolean ret = super.registerUser((Masseur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(boolean.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Masseur/recupererTousLesMasseur", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererTousLesMasseur(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Masseur> ret = super.recupererTousLesMasseur();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Masseur.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Masseur/recupererLeMasseur", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeMasseur(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Masseur ret = super.recupererLeMasseur((Long) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Masseur/buyTournee", method = RequestMethod.POST)
	public GenericTransfereDataDto buyTournee(@RequestBody GenericRequestDataDto rdto) {
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		TournerBuyDto ret = super.buyTournee((TournerBuyDto) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Masseur/mettreAjourMasseur", method = RequestMethod.POST)
	public GenericTransfereDataDto mettreAjourMasseur(@RequestBody GenericRequestDataDto rdto) {
		
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		Masseur ret = super.mettreAjourMasseur((Masseur) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}
	
	@RequestMapping(value = "/private/Masseur/enregistrerCommande", method = RequestMethod.POST)
	public GenericTransfereDataDto enregistrerCommande(@RequestBody GenericRequestDataDto rdto) {
		//TODO
		System.out.println("SASASASASASA");
		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		CommandeDto ret = super.enregistrerCommande((CommandeDto) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}
}