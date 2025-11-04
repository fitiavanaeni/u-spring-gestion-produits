package com.fitiavana.produits.repositories;


import com.fitiavana.produits.entities.Produit;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

@DataJpaTest
class ProduitRepositoryTest {

    @Autowired
    ProduitRepository produitRepository;

    @Test

    void getAllProduits(){
        List<Produit> produits = produitRepository.findAll();

        Assertions.assertEquals(4, produits.size());
    }

}