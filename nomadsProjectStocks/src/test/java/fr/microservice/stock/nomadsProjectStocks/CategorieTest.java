package fr.microservice.stock.nomadsProjectStocks;

import static org.junit.Assert.assertEquals;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import fr.microservice.stock.nomads.GestionStocksApplication;
import fr.microservice.stock.nomads.entities.Categorie;
import fr.microservice.stock.nomads.service.CategorieService;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {GestionStocksApplication.class})
public class CategorieTest {
	
	@Autowired
	private CategorieService categorieService;
	
	@Test
	public void testRechercherToutesLesCategories() {
		List<Categorie> categories = categorieService.rechercherToutesLesCategories();
		assertEquals(categories.size(), 5);
	}

	@Test
	public void testRechercherCategorieParId() {
		Categorie categorieDeTest = categorieService.rechercherCategorieParId(1L);
		assertEquals(categorieDeTest.getIdCategorie(), 1L, 000000.1);
	}
	
	@Test
	public void testSavaugarderCategorie() {
		List<Categorie> categories = categorieService.rechercherToutesLesCategories();
		int size1 = categories.size();
		Categorie categorieDeTest = new Categorie("Categorie de test");
		categorieService.savaugarderCategorie(categorieDeTest);
		List<Categorie> categories2 = categorieService.rechercherToutesLesCategories();
		int size2 = categories2.size();
		assertEquals(size2, size1 + 1);
		categorieService.supprimerCategorie(categorieDeTest.getIdCategorie());
	}
	
	@Test
	public void testSupprimerCategorie() {
		Categorie categorieDeTest = new Categorie("Categorie de test");
		categorieService.savaugarderCategorie(categorieDeTest);
		Categorie categorie = categorieService.rechercherCategorieParId(categorieDeTest.getIdCategorie());
		categorieService.supprimerCategorie(categorie.getIdCategorie());
		assertEquals(categorieService.rechercherToutesLesCategories().size(), 5);
	}
	
}
