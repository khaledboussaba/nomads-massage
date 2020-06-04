package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.context.annotation.SessionScope;

import fr.afcepf.al34.nomads.business.ProduitBusiness;
import fr.afcepf.al34.nomads.entities.Produit;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@ManagedBean
@SessionScope
@Getter @Setter @NoArgsConstructor 
public class ProduitAchatManagedBean implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5116451293420460341L;

	@Autowired
	private ProduitBusiness produitBusiness; 
	
	private List<Produit> listeDesTshirt;
	
	
	private List<Produit> listeDesTable;
	private List<Produit> listeDesPacksCredits;
	
	@PostConstruct
	public void init() {
		listeDesTshirt = produitBusiness.recupererLaListeDesTshirt();
		listeDesPacksCredits = produitBusiness.recupererLaListeDesPacks();
	}

}
