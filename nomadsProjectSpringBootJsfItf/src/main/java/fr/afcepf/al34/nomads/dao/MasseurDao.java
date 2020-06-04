package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Masseur;

public interface MasseurDao extends GenericDao<Masseur> {
	List<Masseur> getAllUtilisateurs();
	Masseur sauvegarderUtilisateur(Masseur utilisateur);
	Masseur getUtilisateurById(Long idUtilisateur);
	boolean loginNoExist(String login);
	/*
	 * @author: Khaled
	 */
	List<Masseur> getAllMasseurs();
	Long updateCreditMasseur(Long id, Long porteMonnaie);
	
}
