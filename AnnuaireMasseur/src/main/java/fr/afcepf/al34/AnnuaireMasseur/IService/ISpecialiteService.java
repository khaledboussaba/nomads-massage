package fr.afcepf.al34.AnnuaireMasseur.IService;

import java.util.List;

import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;

public interface ISpecialiteService {
	
	List<Specialite> getAllSpecialtes();
	
	Specialite getSpecialiteById(Long id); 

}
