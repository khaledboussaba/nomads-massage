package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Utilisateur;

public interface CommanditaireServiceDelegate {

	/* 
	 * @Author : Khaled
	 */
	List<Commanditaire> recupererTousLesCommanditaires();

	/**
	 * Author Sami
	 */
	Utilisateur registerUser(Commanditaire utilisateur) throws Exception;

	Commanditaire recupererCommanditaire(Long id);

}
