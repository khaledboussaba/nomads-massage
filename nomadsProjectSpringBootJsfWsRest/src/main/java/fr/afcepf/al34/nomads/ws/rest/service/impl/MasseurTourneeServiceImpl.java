package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dao.MasseurTourneeDao;
import fr.afcepf.al34.nomads.entities.MasseurTournee;
import fr.afcepf.al34.nomads.service.MasseurTourneeService;

@Service
public class MasseurTourneeServiceImpl implements MasseurTourneeService {

	@Autowired
	private MasseurTourneeDao proxyDao;

	@Override
	public List<MasseurTournee> recupererLaListeDesMasseursTournee(Long id) {
		return proxyDao.getListMasseurTournee(id);
	}

	@Override
	public MasseurTournee ajouterUnMasseurTournee(MasseurTournee mt) {
		return proxyDao.insert(mt);
	}
	
	

}
