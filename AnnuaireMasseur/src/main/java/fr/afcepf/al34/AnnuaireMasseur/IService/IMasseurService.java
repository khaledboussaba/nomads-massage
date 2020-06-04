package fr.afcepf.al34.AnnuaireMasseur.IService;

import java.util.List;

import fr.afcepf.al34.AnnuaireMasseur.entity.Masseur;

public interface IMasseurService {
	
	List<Masseur> getAllMasseurs();
	
	Masseur getMasseurById(Long id);

}
