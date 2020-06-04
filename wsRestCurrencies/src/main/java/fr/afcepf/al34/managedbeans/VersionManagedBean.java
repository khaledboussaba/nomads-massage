package fr.afcepf.al34.managedbeans;

import javax.annotation.ManagedBean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.info.BuildProperties;

import fr.afcepf.al34.managedbeans.interfaces.IVersionManagedBean;
import lombok.NoArgsConstructor;

@ManagedBean("versionMb")
@NoArgsConstructor
public class VersionManagedBean implements IVersionManagedBean{
	private String version = "0";
	private String name = "";
	@Autowired
	BuildProperties buildProperties;

	public String getVersion() {
		if(version.equalsIgnoreCase("0")) {
			setVersion(version=buildProperties.getVersion()+"_"+buildProperties.getTime());
		}
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public String getName() {
		if(name.equalsIgnoreCase("")) {
			setName(buildProperties.getName());
		}
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
