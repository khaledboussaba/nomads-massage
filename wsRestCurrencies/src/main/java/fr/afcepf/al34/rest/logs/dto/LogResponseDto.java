package fr.afcepf.al34.rest.logs.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor @Getter @Setter
public class LogResponseDto {

	boolean logOk;
	String error;
}
