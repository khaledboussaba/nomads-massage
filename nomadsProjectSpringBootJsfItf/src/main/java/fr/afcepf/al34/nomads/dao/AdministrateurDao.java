package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Administrateur;

public interface AdministrateurDao {
	public List<Administrateur> getAllUtilisateurs();
	public Administrateur sauvegarderUtilisateur(Administrateur utilisateur);
	public Administrateur getUtilisateurById(Long idUtilisateur);
}
