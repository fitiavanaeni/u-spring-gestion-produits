package com.fitiavana.produits.entities;

import com.fitiavana.produits.repositories.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootTest
class ProduitsManagementApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Test
	public void testCreateProduit() {
		Categorie cat = new Categorie();
		cat.setIdCat(2L);
		Produit prod = new Produit("DeskJET",400.50,new Date(),cat);
		produitRepository.save(prod);
	}
	@Test
	public void testFindProduit(){
		Produit p = produitRepository.findById(1L).get();
		System.out.println(p);
	}

	@Test
	public void testUpdateProduit(){
		Produit p = produitRepository.findById(1L).get();

		//Categorie cat = new Categorie();
		//cat.setIdCat(2L);
		//p.setCategorie(cat);
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
		System.out.println(p);

	}

	/*
	@Test
	public void testUpdateMultipleProduits() {
		List<Long> ids = List.of(4L, 6L, 7L, 8L);

		Categorie nouvelleCategorie = new Categorie();
		nouvelleCategorie.setIdCat(1L); // Ex: on veut tous les affecter à la catégorie 2

		for (Long id : ids) {
			Optional<Produit> optionalProduit = produitRepository.findById(id);
			if (optionalProduit.isPresent()) {
				Produit p = optionalProduit.get();
				p.setCategorie(nouvelleCategorie);
				// Tu peux modifier d'autres champs ici aussi si tu veux
				p.setPrixProduit(1999.99); // Par exemple
				produitRepository.save(p); // Sauvegarder chaque modification
				System.out.println("Modifié : " + p);
			} else {
				System.out.println("Produit avec ID " + id + " non trouvé.");
			}
		}
	}

*/
	@Test
	public void testDeleteProduit(){
		produitRepository.deleteById(5L);
	}
	@Test
	public void testFindAllProduit(){
		List<Produit> prods = produitRepository.findAll();
		for(Produit p : prods) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomProduit(){
		List<Produit> prods = produitRepository.findByNomProduit("PC HP");
		for(Produit p : prods) {
			System.out.println(p);
		}
	}

	@Test
	public void testFindByNomProduitContains(){
		List<Produit> prods = produitRepository.findByNomProduitContains("P");
		for(Produit p : prods) {
			System.out.println(p);
		}
	}
	@Test
	public void testFindByNomPrixProduit(){
		List<Produit> prods = produitRepository.findByNomPrix("P", 500.00);
		for(Produit p : prods){
			System.out.println(p);
		}
	}
	@Test
	public void testFindByCategorie(){
		Categorie cat = new Categorie();
		cat.setIdCat(2L);

		List<Produit> prods = produitRepository.findByCategorie(cat);
		for (Produit p :prods){
			System.out.println(p);
		}
	}
	@Test
	public void testFindByCategorieIdCat(){
		List<Produit> prods = produitRepository.findByCategorieIdCat(2L);
		for (Produit p: prods){
			System.out.println(p);
		}
	}

	@Test
	public void testFindByOrderByNomProduitAsc(){
		List<Produit> prods = produitRepository.findByOrderByNomProduitAsc();
		prods.forEach(System.out::println);
	}
	@Test
	public void testTrierProduitsNomsPrix(){
		List<Produit> prods = produitRepository.trierProduitsNomsPrix();
		for (Produit p: prods){
			System.out.println(p);
		}
	}
}
