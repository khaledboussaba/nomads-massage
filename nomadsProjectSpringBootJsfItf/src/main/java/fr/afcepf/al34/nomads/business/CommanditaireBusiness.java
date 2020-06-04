package fr.afcepf.al34.nomads.business;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Commanditaire;

public interface CommanditaireBusiness {

	/* 
	 * @Author : Khaled
	 */
	List<Commanditaire> recupererTousLesCommanditaires();

	/**
	 * Author Sami
	 */
	Commanditaire registerUser(Commanditaire utilisateur) throws Exception;

	Commanditaire recupererCommanditaire(Long id);

}
