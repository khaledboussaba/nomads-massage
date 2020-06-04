package fr.afcepf.al34.nomads.ws.rest.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import fr.afcepf.al34.nomads.dao.CommandeDao;
import fr.afcepf.al34.nomads.dao.LigneCommandeDao;
import fr.afcepf.al34.nomads.dao.ProduitDao;
import fr.afcepf.al34.nomads.entities.ArticleFournisseur;
import fr.afcepf.al34.nomads.entities.Commande;
import fr.afcepf.al34.nomads.entities.LigneCommande;
import fr.afcepf.al34.nomads.service.CommandeService;

@Service
public class CommandeServiceImpl implements CommandeService {
	
	@Autowired
	private CommandeDao proxyDao;
	
	@Autowired
	private LigneCommandeDao ligneProxyDao;
	
	@Autowired
	private ProduitDao produitProxyDao;


	@Override
	@Transactional
	public Commande enregisterCommande(Commande commandeASauvegarder) {
		commandeASauvegarder=proxyDao.insert(commandeASauvegarder);
		for(LigneCommande l:commandeASauvegarder.getLigneCommandes()) {
			if(l.getProduit() instanceof ArticleFournisseur) {
				ArticleFournisseur a=produitProxyDao.findByIdFournisseur(((ArticleFournisseur) l.getProduit()));
				if(a==null) {
					System.out.println("SASASASA l.getProduit().getId()="+l.getProduit().getId());
					produitProxyDao.insert(l.getProduit());
				}else {
					l.setProduit(a);
				}
			}
			
			l.setCommande(commandeASauvegarder);
			ligneProxyDao.insert(l);
		}
		
		return commandeASauvegarder;
	}

}
