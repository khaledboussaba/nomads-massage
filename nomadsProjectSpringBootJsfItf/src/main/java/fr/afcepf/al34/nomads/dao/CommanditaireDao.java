package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Commanditaire;
import fr.afcepf.al34.nomads.entities.Masseur;

public interface CommanditaireDao extends GenericDao<Commanditaire> {
	public List<Masseur> getAllUtilisateurs();
	public Commanditaire sauvegarderUtilisateur(Commanditaire utilisateur);
	public Commanditaire getUtilisateurById(Long idUtilisateur);
	/* 
	 * @Author : Khaled
	 */
	public List<Commanditaire> getAllCommanditaires();
	/* 
	 * @Author : Khaled
	 */
	public Commanditaire getCommanditaireWhitId7(Long l);
}
