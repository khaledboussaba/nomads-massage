package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.nomads.dao.LieuTourneeDao;
import fr.afcepf.al34.nomads.dao.TourneeDao;
import fr.afcepf.al34.nomads.dto.TournerDto;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.entities.Masseur;
import fr.afcepf.al34.nomads.entities.Tournee;
import fr.afcepf.al34.nomads.service.TourneeService;

@Service
public class TourneeServiceImpl implements TourneeService {

	@Autowired
	private TourneeDao proxyDao;
	
	@Autowired
	private LieuTourneeDao proxyLieuTourneeDao;
	
	@Override
	public Tournee ajouterTournee(Tournee tournee) {
		tournee.setPrixCredit(1L);
		proxyDao.insert(tournee);
		return tournee;
	}

	@Override
	public List<LieuTournee> recupererLaListeDesTourneesDisponible(Long id) {
		return proxyDao.getAllTourneesDispo(id);
	}

	@Override
	public List<Tournee> recupererLaListeDesTourneesDuMasseur(Long id) {
		return proxyDao.getTourneesMasseur(id);
	}

	@Override
	public List<Masseur> recupererLaListeDesMasseurInscritTournees(List<Tournee> mesTournees) {
		return proxyDao.getTourneesMasseur(mesTournees);
	}

	@Transactional
	public TournerDto ajouterTournee(TournerDto tdto) {
		
		tdto.setTournee(ajouterTournee(tdto.getTournee()));
		tdto.getTournee().setPrixCredit(1L);
		LieuTournee lt = new LieuTournee();
		lt.setLieu(tdto.getLieuSelected());
		lt.setTournee(tdto.getTournee());
		proxyLieuTourneeDao.ajouterUnLieuTournee(lt);
		
		
		
		
		tdto.setLieuxTournees(
				proxyLieuTourneeDao.getAllLieuAndTournees(tdto.getCommanditaireId()));
									
		return tdto;
	}

}
