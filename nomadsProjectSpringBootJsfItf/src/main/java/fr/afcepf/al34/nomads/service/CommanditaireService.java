package fr.afcepf.al34.nomads.service;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Commanditaire;

public interface CommanditaireService {

	/* 
	 * @Author : Khaled
	 */
	List<Commanditaire> recupererTousLesCommanditaires();

	/**
	 * Author Sami
	 */
	boolean registerUser(Commanditaire utilisateur) throws Exception;

	Commanditaire recupererCommanditaire(Long id);

}
