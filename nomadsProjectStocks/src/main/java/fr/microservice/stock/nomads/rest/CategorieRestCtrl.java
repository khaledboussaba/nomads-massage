package fr.microservice.stock.nomads.rest;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import fr.microservice.stock.nomads.dto.ResDelete;
import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.service.CategorieService;

@RestController
@RequestMapping(value = "/stock-api/public/categorie", headers = "Accept=application/json")
public class CategorieRestCtrl {
	
	@Autowired
	private CategorieService categorieService;
	
	@RequestMapping(value = "/{idCategorie}", method = RequestMethod.GET)
	public Categorie getCategorieById(@PathVariable("idCategorie") Long id) {
		return categorieService.rechercherCategorieParId(id);
	}
	
	@PostMapping
	public Categorie postCategorie(@Valid @RequestBody Categorie categorie) {
		return categorieService.savaugarderCategorie(categorie);
	}
	
	@PutMapping
	public void updateCategorie(@RequestBody Categorie categorie) {
		categorieService.savaugarderCategorie(categorie);
	}
	
	@DeleteMapping(value = "/{idCategorie}")
	public ResponseEntity<ResDelete> deleteCategorie(@PathVariable("idCategorie") Long id) {
		try {
			categorieService.supprimerCategorie(id);
			return new ResponseEntity<ResDelete>(new ResDelete("suppression bien effectuée"), HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<ResDelete>(new ResDelete("devise déja supprimée ou inexistante"), HttpStatus.OK);
		}
	}

}
