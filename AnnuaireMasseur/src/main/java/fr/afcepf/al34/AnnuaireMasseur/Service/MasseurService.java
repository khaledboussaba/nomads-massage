package fr.afcepf.al34.AnnuaireMasseur.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.AnnuaireMasseur.IDao.IMasseurDao;
import fr.afcepf.al34.AnnuaireMasseur.IService.IMasseurService;
import fr.afcepf.al34.AnnuaireMasseur.entity.Masseur;

@Service
public class MasseurService implements IMasseurService {

	@Autowired
	private IMasseurDao masseurDao; 
	
	@Override
	public List<Masseur> getAllMasseurs() {
		return (List<Masseur>) masseurDao.findAll();
	}

	@Override
	public Masseur getMasseurById(Long id) {
		return masseurDao.findById(id).orElse(null);
	}


}
