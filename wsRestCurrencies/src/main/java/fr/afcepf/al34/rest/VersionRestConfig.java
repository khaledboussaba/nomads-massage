package fr.afcepf.al34.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.afcepf.al34.dto.StringDto;
import fr.afcepf.al34.managedbeans.interfaces.IVersionManagedBean;

@RestController
@RequestMapping(value = "/api", headers = "Accept=application/json")
public class VersionRestConfig {

	@Autowired
	private IVersionManagedBean versionManagedBean;
	
	@RequestMapping(value = "/version", method = RequestMethod.GET)
	public StringDto getVersion() {
		StringDto stringDto=new StringDto();
		stringDto.setValue(versionManagedBean.getVersion());
		return stringDto;
	}
	
	@RequestMapping(value = "/serviceName", method = RequestMethod.GET)
	public StringDto getName() {
		StringDto stringDto=new StringDto();
		stringDto.setValue(versionManagedBean.getName());
		return stringDto;
	}
	
}
