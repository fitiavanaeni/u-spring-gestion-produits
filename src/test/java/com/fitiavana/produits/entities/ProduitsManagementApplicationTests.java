package com.fitiavana.produits.entities;

import com.fitiavana.produits.repositories.ProduitRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;
import java.util.List;

@SpringBootTest
class ProduitsManagementApplicationTests {

	@Autowired
	private ProduitRepository produitRepository;
	@Test
	public void testCreateProduit() {
		Produit prod = new Produit("PC THINKPAD",1800.50,new Date());
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
		p.setPrixProduit(2000.0);
		produitRepository.save(p);
		System.out.println(p);

	}

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
	public void testFindByNomProdluitContains(){
		List<Produit> prods = produitRepository.findByNomProduitContains("A");
		for(Produit p : prods) {
			System.out.println(p);
		}
	}
}
