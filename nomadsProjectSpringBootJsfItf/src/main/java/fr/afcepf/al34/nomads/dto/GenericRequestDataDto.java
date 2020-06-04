package fr.afcepf.al34.nomads.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter @Setter @NoArgsConstructor @ToString
public class GenericRequestDataDto {
	private String url;
	private boolean list;
	private Object value;
	private Class<?> postClass;
	
	public GenericRequestDataDto(String url, boolean list, Object value) {
		super();
		this.url = url;
		this.list = list;
		this.value = value;
	}
	
}
