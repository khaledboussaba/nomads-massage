package fr.afcepf.al34.restSkeleton.managedBeans;

import javax.annotation.ManagedBean;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean("versionMb")
@Getter
@Setter
@NoArgsConstructor
public class VersionManagedBean {
	private String version = "0";

}
