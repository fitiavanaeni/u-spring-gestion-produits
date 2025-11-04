package com.fitiavana.produits.services;

import com.fitiavana.produits.entities.Categorie;
import com.fitiavana.produits.entities.Produit;
import dto.ProduitDTO;

import java.util.List;

public interface ProduitService {

    ProduitDTO saveProduit(ProduitDTO p);
    ProduitDTO updateProduit(ProduitDTO p);

   // ProduitDTO saveProduit(Produit p);
    ProduitDTO getProduit(Long id);
    List<ProduitDTO> getAllProduits();
    //Produit saveProduit(Produit p);
    //Produit updateProduit(Produit p);
    void deleteProduit(Produit p);
   // void deleteProduitById(Long id);
   // Produit getProduit(Long id);
   // List<Produit> getAllProduits();
    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
    List<Produit> findByNomPrix (String nom, Double prix);
    List<Produit> findByCategorie (Categorie categorie);
    List<Produit> findByCategorieIdCat(Long id);
    List<Produit> findByOrderByNomProduitAsc();
    List<Produit> trierProduitsNomsPrix();

    ProduitDTO convertEntityToDto (Produit produit);
    Produit convertDtoToEntity(ProduitDTO produitDto);

}
