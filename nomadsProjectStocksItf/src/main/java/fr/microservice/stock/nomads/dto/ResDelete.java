package fr.microservice.stock.nomads.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class ResDelete {

	private String message;

	public ResDelete(String message) {
		super();
		this.message = message;
	}
	
}
