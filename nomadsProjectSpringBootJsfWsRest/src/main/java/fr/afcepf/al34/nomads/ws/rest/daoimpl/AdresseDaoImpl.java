package fr.afcepf.al34.nomads.ws.rest.daoimpl;


import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.AdresseDao;
import fr.afcepf.al34.nomads.entities.Adresse;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class AdresseDaoImpl extends GenericDaoImpl<Adresse> implements AdresseDao {

}
