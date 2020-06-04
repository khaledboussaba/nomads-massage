package fr.afcepf.al34.nomads.business;
import java.util.List;

import fr.afcepf.al34.nomads.entities.Titre;

public interface StaticListBusiness {
	List<Titre> getListTitre();

	List<String> getListCodePostaux();

	List<String> getListVille();
}
