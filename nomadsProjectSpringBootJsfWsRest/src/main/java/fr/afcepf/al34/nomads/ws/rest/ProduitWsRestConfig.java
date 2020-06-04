package fr.afcepf.al34.nomads.ws.rest;

import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.entities.Materiel;
import fr.afcepf.al34.nomads.entities.PackCredit;
import fr.afcepf.al34.nomads.entities.Produit;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.ws.rest.service.impl.ProduitServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class ProduitWsRestConfig extends ProduitServiceImpl {

		
	@RequestMapping(value = "/private/Produit/recupererLaListeDesTshirt", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesTshirt(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Produit> ret = super.recupererLaListeDesTshirt();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Materiel.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLaListeDesPacks", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesPacks(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Produit> ret = super.recupererLaListeDesPacks();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(PackCredit.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeTshirtDisponile", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeTshirtDisponile(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeTshirtDisponile();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeTPEdisponile", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeTPEdisponile(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeTPEdisponile();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreFormulesPacks", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreFormulesPacks(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreFormulesPacks();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeChaisesdisponile", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeChaisesdisponile(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeChaisesdisponile();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLaListeDesTPE", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesTPE(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Produit> ret = super.recupererLaListeDesTPE();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Materiel.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLaListeDesChaises", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesChaises(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Produit> ret = super.recupererLaListeDesChaises();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Materiel.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeBarActifs", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeBarActifs(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeBarActifs();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeBarEnAttente", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeBarEnAttente(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeBarEnAttente();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeBarInactifs", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeBarInactifs(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeBarInactifs();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeMasseursActifs", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeMasseursActifs(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeMasseursActifs();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeMasseursInactifs", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeMasseursInactifs(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeMasseursInactifs();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeTourneesAVenir", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeTourneesAVenir(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeTourneesAVenir();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeTourneesAVenirEtComplete", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeTourneesAVenirEtComplete(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeTourneesAVenirEtComplete();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeTourneesAVenirEtSemiComplete", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeTourneesAVenirEtSemiComplete(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeTourneesAVenirEtSemiComplete();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLeNombreDeTourneesAVenirEtVide", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLeNombreDeTourneesAVenirEtVide(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Long ret = super.recupererLeNombreDeTourneesAVenirEtVide();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(ret.getClass());
		return tdto;
	}
	
	@RequestMapping(value = "/private/Produit/recupererLaListeDesBarsEnAttente", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDesBarsEnAttente(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Lieu> ret = super.recupererLaListeDesBarsEnAttente();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Lieu.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Produit/recupererLaListeDeToutesLesTournnesAVenir", method = RequestMethod.POST)
	public GenericTransfereDataDto recupererLaListeDeToutesLesTournnesAVenir(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		List<Tournee> ret = super.recupererLaListeDeToutesLesTournnesAVenir();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), true, ret);
		tdto.setRetClass(Tournee.class);
		return tdto;
	}

}
