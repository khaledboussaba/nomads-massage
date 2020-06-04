package fr.afcepf.al34.nomads.ws.rest;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.entities.Credentials;
import fr.afcepf.al34.nomads.entities.Utilisateur;
import fr.afcepf.al34.nomads.ws.rest.service.impl.account.LoginServiceImpl;

@RestController
@RequestMapping(value = "/api-nomads", headers = "Accept=application/json")
public class LoginWsRestConfig extends LoginServiceImpl {

	public LoginWsRestConfig() {
		super();
		System.out.println("http://localhost:8080/api-nomads/public/Login/getUserByLogin?rdto=admin");
	}

	@RequestMapping(value = "/private/Login/isUniqueLogin", method = RequestMethod.POST)
	public GenericTransfereDataDto isUniqueLogin(@RequestBody GenericRequestDataDto rdto) {
		boolean ret = super.isUniqueLogin();
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		tdto.setRetClass(boolean.class);
		return tdto;
	}

	@RequestMapping(value = "/private/Login/userNotExisting", method = RequestMethod.POST)
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

	@RequestMapping(value = "/private/Login/connexion", method = RequestMethod.POST)
	public synchronized GenericTransfereDataDto connexion(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);
		
		boolean ret=false;
		Exception ex=null;
		try {
			ret = super.connexion();
			ex=new Exception("Auth Fail!!!");
		} catch (Exception e) {
			ret = false;
			ex=e;
		}finally {
			if(ret) {
				tdto.setValue(ret);
				tdto.setRetClass(boolean.class);
			}else {
				tdto.setValue(null);
				tdto.setRetClass(null);
				tdto.setException(true);
				tdto.setExceptionMessage(ex.getMessage());
			}
		}

		return tdto;
	}

	@RequestMapping(value = "/private/Login/getUserByLogin", method = RequestMethod.POST)
	public GenericTransfereDataDto getUserByLogin(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		Utilisateur ret = super.getUserByLogin();
		
		
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		
		if(ret==null) {
			Exception ex=new Exception("Auth Fail!!!");
			tdto.setException(true);
			tdto.setExceptionMessage(ex.getMessage());
			tdto.setRetClass(null);
		}else {
			tdto.setRetClass(ret.getClass());
		}
		return tdto;
	}

	/*
	 * login from register page
	 */
	@RequestMapping(value = "/private/Login/userLoginUtilisateur", method = RequestMethod.POST)
	public GenericTransfereDataDto userLoginUtilisateur(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);
		boolean ret=false;
		Exception ex=null;
		try {
			ret = super.userLogin((Utilisateur) rdto.getValue());
			tdto.setValue(ret);
			tdto.setRetClass(boolean.class);
		} catch (Exception e) {
			ret = false;
			ex=e;
		}finally {
			if(ret) {
				tdto.setValue(ret);
				tdto.setRetClass(boolean.class);
			}else {
				tdto.setValue(null);
				tdto.setRetClass(null);
				tdto.setException(true);
				tdto.setExceptionMessage(ex.getMessage());
			}
		}
		return tdto;
	}

	/*
	 * Login from login page
	 */
	@RequestMapping(value = "/private/Login/userLoginCredentials", method = RequestMethod.POST)
	public GenericTransfereDataDto userLoginCredentials(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}
		
		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, null);
		try {
			boolean ret = super.userLogin((Credentials) rdto.getValue());
			tdto.setValue(ret);
			tdto.setRetClass(boolean.class);
		} catch (Exception e) {
			tdto.setException(true);
			tdto.setExceptionMessage(e.getMessage());
		}
		return tdto;
	}

	@RequestMapping(value = "/private/Login/getUserByCredentials", method = RequestMethod.POST)
	public GenericTransfereDataDto getUserByCredentials(@RequestBody GenericRequestDataDto rdto) {

		if (rdto.getValue() != null) {
			Object tmpReq = (new ObjectMapper()).convertValue(rdto.getValue(), rdto.getPostClass());
			rdto.setValue(tmpReq);
		}

		Utilisateur ret = super.getUserByCredentials((Credentials) rdto.getValue());

		GenericTransfereDataDto tdto = new GenericTransfereDataDto(rdto.getUrl(), false, ret);
		if(ret==null) {
			Exception ex=new Exception("Auth Fail!!!");
			tdto.setException(true);
			tdto.setExceptionMessage(ex.getMessage());
			tdto.setRetClass(null);
		}else {
			tdto.setRetClass(ret.getClass());
		}
		return tdto;
	}

}
