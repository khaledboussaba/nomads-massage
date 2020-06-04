package fr.afcepf.al34.nomads.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

import fr.afcepf.al34.nomads.dto.GenericRequestDataDto;
import fr.afcepf.al34.nomads.dto.GenericTransfereDataDto;
import fr.afcepf.al34.nomads.service.LoggerService;

public class GenericDelegateImpl {

	private RestTemplate restTemplate = new RestTemplate();

	ObjectMapper jsonMapper = new ObjectMapper();
	
	@Autowired
	private LoggerService logger;
	
	@Value(value = "${nomads-api.base-url}")
	protected String baseUrl;

	@Value(value = "${nomads-api.private.base-url}")
	protected String basePrivateUrl;

	protected String baseClassName;
	protected String baseSuburl;
	private String[] toRemove = { "BusinessImpl", "ServiceDelegateImpl" };

	public GenericDelegateImpl() {
		super();
		baseClassName = this.getClass().getSimpleName();
		// System.out.println("baseClassName="+baseClassName);

		for (int i = 0; i < toRemove.length; i++) {
			if (baseClassName.contains(toRemove[i])) {
				baseClassName = baseClassName.replace(toRemove[i], "");
			}
		}

		baseSuburl = "" + baseClassName;
		// System.out.println("baseSuburl="+baseSuburl);

	}

	public GenericTransfereDataDto callRest(GenericRequestDataDto req) {
		GenericTransfereDataDto ret = null;
		Object tmpRet = null;
		if(req.getValue()!=null && req.getPostClass()==null) {
			req.setPostClass(req.getValue().getClass());
		}else {
			//TODO : test islist in resquest to
			
			
		}
		
		
		//appel de la requete en POST ou GET(inactiver)
//		if (req.getValue() == null) {
//			ret = getRest(req);
//		} else {
			ret = postRest(req);
//		}

		if (ret.getValue() != null) {
//			System.out.println("________RETURN FROM REST________");
//			System.out.println("RETURN VALUE: "+ret.getValue());
//			System.out.println("RETURN CLASS: "+ret.getRetClass());

			if(ret.isList()) {
				//on transforme le Json recu d'une string json en List<Objet> Objet class donner
				JavaType type = jsonMapper.getTypeFactory().
						  constructCollectionType(List.class, ret.getRetClass());
				tmpRet = jsonMapper.convertValue(ret.getValue(), type);
				
			}else {
				//on transform le Json recu d'une string json en Objet donner
				tmpRet = jsonMapper.convertValue(ret.getValue(), ret.getRetClass());
				
			}
			ret.setValue(tmpRet);
		}else {
			System.out.println("retValue from rest is null");
		}
		return ret;
	}

//	public GenericTransfereDataDto getRest(GenericRequestDataDto req) {
//		String url = baseUrl + "/" + req.getUrl();
//
//		System.out.println("GET:" + url);
//
//		GenericTransfereDataDto object = restTemplate.getForObject(url, GenericTransfereDataDto.class);
//		return object;
//	}

	public GenericTransfereDataDto postRest(GenericRequestDataDto req) {
		String url = basePrivateUrl + "/" + req.getUrl();
		System.out.println("POST:" + url);

		logSent(req);
		
		GenericTransfereDataDto object = restTemplate.postForObject(url, req, GenericTransfereDataDto.class);
		
		logReceived(object);
		return object;
	}
	
	private void logSent(GenericRequestDataDto req) {
		logger.logIntoMongo(req, "webSent");
	}
	
	private void logReceived(GenericTransfereDataDto res) {
		logger.logIntoMongo(res, "webReceived");
	}
	
	

}
