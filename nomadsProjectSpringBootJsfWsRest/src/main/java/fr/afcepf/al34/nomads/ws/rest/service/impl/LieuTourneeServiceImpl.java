package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.LieuTourneeDao;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.service.LieuTourneeService;

@Repository
public class LieuTourneeServiceImpl implements LieuTourneeService {
	
	@Autowired
	private LieuTourneeDao proxyDao;



	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees() {
		return proxyDao.getAllLieuAndTournees();
	}

	@Override
	public void ajouterUnLieuTournee(LieuTournee lt) {
		proxyDao.ajouterUnLieuTournee(lt);
	}

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTourneesCommanditaire(Long id) {
		return proxyDao.getAllLieuAndTourneesCommanditaire(id);
	}

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees(Long id) {
		return proxyDao.getAllLieuAndTournees(id);
	}

	@Override
	public List<LieuTournee> recupererLesLieuxTourneesDisponibles() {
		return proxyDao.getLieuxTourneesDisponibles();
	}

	@Override
	public List<LieuTournee> recupererLesLieuxTourneesDisponibles(Long id) {
		return proxyDao.getLieuxTourneesDisponibles(id);
	}

}
