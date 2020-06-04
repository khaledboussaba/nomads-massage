package fr.afcepf.al34.nomads.web.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;

import org.hibernate.mapping.Array;
import org.springframework.beans.factory.annotation.Autowired;

import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;
import fr.afcepf.al34.nomads.service.AnnuaireService;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter @Setter @NoArgsConstructor 
@ManagedBean("mbAnnuaire")
public class AnnuaireManagedBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 2246632154055789131L;

	@Autowired
	private AnnuaireService annuaireService;	
	
	private List<Specialite> specialites;
	private Specialite specialiteChoisie;
	
	@PostConstruct
	public void initAnnuaire() {
		try {	
			specialites=annuaireService.afficherToutesLesSpecialites();
		}catch(Exception e) {
			specialites=new ArrayList<Specialite>();
		}
	}
	

}

