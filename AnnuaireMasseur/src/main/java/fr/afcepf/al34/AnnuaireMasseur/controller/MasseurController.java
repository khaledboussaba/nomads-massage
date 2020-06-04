package fr.afcepf.al34.AnnuaireMasseur.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import fr.afcepf.al34.AnnuaireMasseur.IService.IMasseurService;
import fr.afcepf.al34.AnnuaireMasseur.entity.Masseur;

@Controller
//@RequestMapping("masseur")
public class MasseurController {
	@Autowired
	private IMasseurService masseurService;
	
	//consultation de masseurs avec du GetMapping
	@GetMapping("masseur/{id}")
	public ResponseEntity<Masseur> getMasseurById  (@PathVariable Long id){
//	public ResponseEntity<Masseur> getMasseurById  (@PathVariable("id") Long id){
		Masseur masseur= masseurService.getMasseurById(id);
		return new ResponseEntity<Masseur>(masseur,HttpStatus.OK);
		
	}
	@GetMapping("masseurs")
	public ResponseEntity<List<Masseur>> getAllMasseurs  (){
		List<Masseur> masseurs= masseurService.getAllMasseurs();
		return new ResponseEntity<List<Masseur>>(masseurs,HttpStatus.OK);
	}
	
	//TODO creation/update  de masseurs avec du PostMappping 

}
