package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;
import fr.afcepf.al34.nomads.service.AnnuaireService;

@Service
public class AnnuaireBusinessImpl {
	
	
	Specialite selectedSpecialite;
	
	@Autowired
	AnnuaireService annuaireService;
	


}
