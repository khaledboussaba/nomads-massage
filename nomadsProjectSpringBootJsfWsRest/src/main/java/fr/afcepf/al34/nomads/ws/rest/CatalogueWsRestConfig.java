package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.ws.rest.service.impl.CatalogueServiceImpl;


@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class CatalogueWsRestConfig extends CatalogueServiceImpl {
	
	@RequestMapping(value = "/private/Catalogue/afficherTousProduits", method = RequestMethod.POST)
	public GenericTransfereDataDto afficherTousProduits(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Produit> ret = super.afficherTousProduits();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Produit.class);
		return tdto;
	}
	

	@RequestMapping(value = "/private/Catalogue/affichertousPacks", method = RequestMethod.POST)
	public GenericTransfereDataDto affichertousPacks(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<PackCredit> ret = super.affichertousPacks();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(PackCredit.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Catalogue/afficherTousTournees", method = RequestMethod.POST)
	public GenericTransfereDataDto afficherTousTournees(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Tournee> ret = super.afficherTousTournees();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Tournee.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Catalogue/afficheTousMateriels", method = RequestMethod.POST)
	public GenericTransfereDataDto afficheTousMateriels(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Materiel> ret = super.afficheTousMateriels();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Materiel.class);
		return tdto;
	}


	@RequestMapping(value = "/private/Catalogue/recupererParIdProduit", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererParIdProduit(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Produit ret = super.recupererParIdProduit((int) rdto.getValue());
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

}
