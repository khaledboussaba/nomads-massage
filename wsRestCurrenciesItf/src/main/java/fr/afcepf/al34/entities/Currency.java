package fr.afcepf.al34.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity(name = "Currency")
@Table(name="currencies")
@Getter @Setter @NoArgsConstructor
public class Currency {
	
	public Currency(String name, Double value, CurrencyInfo currencyInfo) {
		this();
		setName(name);
		setValue(value);
		setCurrencyInfo(currencyInfo);
	}

	@Id
	@Column(name="currency_name", nullable = false)
	private String name;
	
	@Column(name="currency_value")
	private Double value;
	
	@OneToOne(fetch = FetchType.EAGER ,cascade = {CascadeType.ALL})
    @JoinColumn(name = "currency_info_name")
    private CurrencyInfo currencyInfo;
}
