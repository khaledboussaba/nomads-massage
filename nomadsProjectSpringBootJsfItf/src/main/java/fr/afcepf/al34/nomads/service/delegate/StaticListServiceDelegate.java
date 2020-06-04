package fr.afcepf.al34.nomads.service.delegate;
import java.util.List;

import fr.afcepf.al34.nomads.entities.Titre;

public interface StaticListServiceDelegate {
	List<Titre> getListTitre();

	List<String> getListCodePostaux();

	List<String> getListVille();
}
