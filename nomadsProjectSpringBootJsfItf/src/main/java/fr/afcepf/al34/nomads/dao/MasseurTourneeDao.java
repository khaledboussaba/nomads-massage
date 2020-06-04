package fr.afcepf.al34.nomads.dao;

import java.util.List;

import fr.afcepf.al34.nomads.entities.MasseurTournee;

public interface MasseurTourneeDao extends GenericDao<MasseurTournee> {

	List<MasseurTournee> getListMasseurTournee(Long id);

	List<MasseurTournee> getListAllMasseurTournee();

}
