package fr.afcepf.al34.AnnuaireMasseur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import fr.afcepf.al34.AnnuaireMasseur.IService.ISpecialiteService;
import fr.afcepf.al34.AnnuaireMasseur.entity.Specialite;

@Controller
@RequestMapping(value = "/annuaireMasseur-api/public", headers = "Accept=application/json")
public class SpecialiteController {
	
	@Autowired
	private ISpecialiteService  specialiteService;
	
	@GetMapping("/specialite/{id}")
	public ResponseEntity<Specialite> getSpecialiteById(@PathVariable Long id){
		Specialite specialite= specialiteService.getSpecialiteById(id);
		return new ResponseEntity<Specialite>(specialite,HttpStatus.OK);
	}
	
	@GetMapping("/specialites")
	public ResponseEntity<List<Specialite>> getAllSpecialites(){
		List<Specialite> specialites=specialiteService.getAllSpecialtes();
		return new ResponseEntity<List<Specialite>>(specialites,HttpStatus.OK);
	}

}
