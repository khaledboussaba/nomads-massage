package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Lieu;

public interface LieuDao extends GenericDao<Lieu> {

	Lieu getLieuById(Long idLieu);

	Lieu updateLieu(Lieu lieu);

	List<Lieu> getLieuxCommanditaire(Long id);

	List<Lieu> getLieuxActifsCommanditaire(Long id);

}
