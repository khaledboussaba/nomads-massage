package fr.afcepf.al34.AnnuaireMasseur.IDao;

import org.springframework.data.repository.CrudRepository;

import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;

public interface ISpecialiteDao extends CrudRepository<Specialite, Long> {

}
