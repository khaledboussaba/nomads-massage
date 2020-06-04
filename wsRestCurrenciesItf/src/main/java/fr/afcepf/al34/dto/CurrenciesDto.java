package fr.afcepf.al34.dto;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import fr.afcepf.al34.entities.CurrencyInfo;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter @NoArgsConstructor
public class CurrenciesDto {
	private boolean success;
	private Long timestamp;
	private String base;
	private Date date;
	private Map<String, Double> rates = new HashMap<>();
	private Map<String,CurrencyInfo> ratesInfo = new HashMap<>();
}
