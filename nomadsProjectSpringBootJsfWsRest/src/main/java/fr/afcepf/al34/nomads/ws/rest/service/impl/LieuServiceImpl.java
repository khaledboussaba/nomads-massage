package fr.afcepf.al34.nomads.ws.rest.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.dao.LieuDao;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.service.LieuService;

@Service
public class LieuServiceImpl implements LieuService{

	@Autowired
	private LieuDao proxyDao;

	@Override
	public Lieu recupererLieuParSonId(Long idLieu) {
		return proxyDao.getLieuById(idLieu);
	}

	@Override
	public Lieu mettreAjourLieu(Lieu lieu) {
		return proxyDao.updateLieu(lieu);
	}


	@Override
	public List<Lieu> recupererLieuxCommanditaire(Long id) {
		return proxyDao.getLieuxCommanditaire(id);
	}

	@Override
	public Lieu ajouterUnNouveauLieu(Lieu nouveauLlieu) {
		return proxyDao.insert(nouveauLlieu);
	}

	@Override
	public List<Lieu> recupererLieuxActifCommanditaire(Long id) {
		return proxyDao.getLieuxActifsCommanditaire(id);
	}

}
