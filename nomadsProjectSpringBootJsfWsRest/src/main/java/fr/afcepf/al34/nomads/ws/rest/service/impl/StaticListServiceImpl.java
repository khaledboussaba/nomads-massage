package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.service.StaticListService;
import fr.afcepf.al34.nomads.dao.StaticListDao;
import fr.afcepf.al34.nomads.entities.Titre;
@Service
public class StaticListServiceImpl implements StaticListService{

	@Autowired
	private StaticListDao proxyDao; 
	
	@Override
	public List<Titre> getListTitre() {
		
		return proxyDao.getListTitre();
	}

	@Override
	public List<String> getListCodePostaux() {
		return proxyDao.getCodePostaux();
	}

	@Override
	public List<String> getListVille() {
		return proxyDao.getList();
	}

}
