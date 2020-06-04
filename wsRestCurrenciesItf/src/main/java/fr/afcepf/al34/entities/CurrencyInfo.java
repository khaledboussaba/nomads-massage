package fr.afcepf.al34.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "CurrencyInfo")
@Table(name="currencies_infos")
@Getter @Setter @NoArgsConstructor
public class CurrencyInfo {
	
	public CurrencyInfo(String name, Date lastUpdate) {
		this();
		setName(name);
		setLastUpdate(lastUpdate);
	}

	@Id
	@Column(name="currency_info_name", nullable = false)
	private String name;
	
	@Column(name="updated_date")
	private Date lastUpdate;
}
