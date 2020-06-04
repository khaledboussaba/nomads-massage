package fr.microservice.stock.nomads.logs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class LogResponseDto {

	boolean logOk;
	String error;
}
