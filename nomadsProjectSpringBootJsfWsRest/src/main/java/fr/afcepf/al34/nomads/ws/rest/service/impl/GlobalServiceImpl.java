package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.service.GlobalService;
import fr.afcepf.al34.nomads.dao.LieuTourneeDao;
import fr.afcepf.al34.nomads.entities.LieuTournee;

@Service
public class GlobalServiceImpl implements GlobalService {

	@Autowired
	private LieuTourneeDao proxyDao;
	
	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees() {
		return proxyDao.getAllLieuAndTournees();
	}

}
