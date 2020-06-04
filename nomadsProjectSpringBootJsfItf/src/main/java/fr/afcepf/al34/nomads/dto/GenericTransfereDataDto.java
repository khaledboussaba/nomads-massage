package fr.afcepf.al34.nomads.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class GenericTransfereDataDto {
	private String url="";
	private boolean list=false;
	private Object value=null;;
	private boolean exception=false;
	private String exceptionMessage="";
	private Class<?> retClass;
	
	public GenericTransfereDataDto(String url, boolean list, Object value) {
		super();
		this.url = url;
		this.list = list;
		this.value = value;
	}
	
}
