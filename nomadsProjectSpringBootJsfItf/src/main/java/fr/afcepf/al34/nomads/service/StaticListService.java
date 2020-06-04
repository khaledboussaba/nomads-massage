package fr.afcepf.al34.nomads.service;
import java.util.List;

import fr.afcepf.al34.nomads.entities.Titre;

public interface StaticListService {
	List<Titre> getListTitre();

	List<String> getListCodePostaux();

	List<String> getListVille();
}
