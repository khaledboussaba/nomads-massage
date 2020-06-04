package fr.afcepf.al34.nomads.ws.rest.daoimpl;

import org.springframework.stereotype.Repository;

import fr.afcepf.al34.nomads.dao.CommandeDao;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.ws.rest.dao.GenericDaoImpl;

@Repository
public class CommandeDaoImpl extends GenericDaoImpl<Commande> implements CommandeDao {

}
