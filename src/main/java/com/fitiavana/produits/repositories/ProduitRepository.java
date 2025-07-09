package com.fitiavana.produits.repositories;

import com.fitiavana.produits.entities.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProduitRepository extends JpaRepository<Produit,Long> {

    List<Produit> findByNomProduit(String nom);
    List<Produit> findByNomProduitContains(String nom);
}
