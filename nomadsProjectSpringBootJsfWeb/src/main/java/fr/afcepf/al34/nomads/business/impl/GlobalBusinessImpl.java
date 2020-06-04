package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.GlobalBusiness;
import fr.afcepf.al34.nomads.dao.LieuTourneeDao;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.service.impl.GlobalServiceDelegateImpl;

@Service
public class GlobalBusinessImpl extends GlobalServiceDelegateImpl implements GlobalBusiness {
	
	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees() {
		return super.recupererLesLieuxEtLesTournees();
	}

}
