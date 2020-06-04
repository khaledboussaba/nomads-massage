package fr.microservice.stock.nomads.dao;

import org.springframework.data.repository.CrudRepository;

import fr.microservice.stock.nomads.entities.Categorie;

public interface CategorieDao extends CrudRepository<Categorie, Long> {

}
