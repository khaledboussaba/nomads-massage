package fr.afcepf.al34.nomads.service.delegate;

import java.util.List;

import fr.afcepf.al34.nomads.entities.Lieu;

public interface LieuServiceDelegate {

	Lieu recupererLieuParSonId(Long idLieu);

	Lieu mettreAjourLieu(Lieu lieu);

	List<Lieu> recupererLieuxCommanditaire(Long id);

	Lieu ajouterUnNouveauLieu(Lieu nouveauLlieu);

	List<Lieu> recupererLieuxActifCommanditaire(Long id);

}
