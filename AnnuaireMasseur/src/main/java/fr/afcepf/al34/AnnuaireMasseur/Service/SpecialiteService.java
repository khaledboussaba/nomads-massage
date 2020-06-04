package fr.afcepf.al34.AnnuaireMasseur.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.AnnuaireMasseur.IDao.ISpecialiteDao;
import fr.afcepf.al34.AnnuaireMasseur.IService.ISpecialiteService;
import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;

@Service
public class SpecialiteService implements ISpecialiteService{
	
	@Autowired
	private ISpecialiteDao specialiteDao;

	@Override
	public List<Specialite> getAllSpecialtes() {

		return (List<Specialite>) specialiteDao.findAll();
	}

	@Override
	public Specialite getSpecialiteById(Long id) {
		return specialiteDao.findById(id).orElse(null);
	}

}
