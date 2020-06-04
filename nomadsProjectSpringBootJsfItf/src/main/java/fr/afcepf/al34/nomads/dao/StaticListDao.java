package fr.afcepf.al34.nomads.dao;
import java.util.List;

import fr.afcepf.al34.nomads.entities.Titre;

public interface StaticListDao {
	List<Titre> getListTitre();

	List<String> getCodePostaux();

	List<String> getList();
	
}
