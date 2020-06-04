package fr.afcepf.al34.nomads.business.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import fr.afcepf.al34.nomads.business.LieuTourneeBusiness;
import fr.afcepf.al34.nomads.entities.LieuTournee;
import fr.afcepf.al34.nomads.service.impl.LieuTourneeServiceDelegateImpl;

@Service
public class LieuTourneeBusinessImpl extends LieuTourneeServiceDelegateImpl implements LieuTourneeBusiness {
	

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees() {
		return super.recupererLesLieuxEtLesTournees();
	}

	@Override
	public void ajouterUnLieuTournee(LieuTournee lt) {
		super.ajouterUnLieuTournee(lt);
	}

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTourneesCommanditaire(Long id) {
		return super.recupererLesLieuxEtLesTourneesCommanditaire(id);
	}

	@Override
	public List<LieuTournee> recupererLesLieuxEtLesTournees(Long id) {
		return super.recupererLesLieuxEtLesTournees(id);
	}

	@Override
	public List<LieuTournee> recupererLesLieuxTourneesDisponibles() {
		return super.recupererLesLieuxTourneesDisponibles();
	}

	@Override
	public List<LieuTournee> recupererLesLieuxTourneesDisponibles(Long id) {
		return super.recupererLesLieuxTourneesDisponibles(id);
	}

}
