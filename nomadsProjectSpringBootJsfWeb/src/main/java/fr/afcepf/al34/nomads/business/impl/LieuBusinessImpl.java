package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.LieuBusiness;
import fr.afcepf.al34.nomads.dao.LieuDao;
import fr.afcepf.al34.nomads.entities.Lieu;
import fr.afcepf.al34.nomads.service.impl.LieuServiceDelegateImpl;

@Service
public class LieuBusinessImpl extends LieuServiceDelegateImpl implements LieuBusiness{

	@Override
	public Lieu recupererLieuParSonId(Long idLieu) {
		return super.recupererLieuParSonId(idLieu);
	}

	@Override
	public Lieu mettreAjourLieu(Lieu lieu) {
		return super.mettreAjourLieu(lieu);
	}


	@Override
	public List<Lieu> recupererLieuxCommanditaire(Long id) {
		return super.recupererLieuxCommanditaire(id);
	}

	@Override
	public Lieu ajouterUnNouveauLieu(Lieu nouveauLlieu) {
		return super.ajouterUnNouveauLieu(nouveauLlieu);
	}

	@Override
	public List<Lieu> recupererLieuxActifCommanditaire(Long id) {
		return super.recupererLieuxActifCommanditaire(id);
	}

}
