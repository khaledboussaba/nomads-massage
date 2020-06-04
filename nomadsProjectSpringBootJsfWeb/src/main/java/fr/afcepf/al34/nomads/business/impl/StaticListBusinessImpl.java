package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.StaticListBusiness;
import fr.afcepf.al34.nomads.dao.StaticListDao;
import fr.afcepf.al34.nomads.entities.Titre;
import fr.afcepf.al34.nomads.service.impl.StaticListServiceDelegateImpl;
@Service
public class StaticListBusinessImpl extends StaticListServiceDelegateImpl implements StaticListBusiness{
	
	@Override
	public List<Titre> getListTitre() {
		return super.getListTitre();
	}

	@Override
	public List<String> getListCodePostaux() {
		return super.getListCodePostaux();
	}

	@Override
	public List<String> getListVille() {
		return super.getListVille();
	}

}
