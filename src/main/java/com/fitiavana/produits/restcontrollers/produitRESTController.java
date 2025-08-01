package com.fitiavana.produits.restcontrollers;

import com.fitiavana.produits.entities.Produit;
import com.fitiavana.produits.services.ProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class produitRESTController {

    @Autowired
    private ProduitService produitService;

    @RequestMapping(method = RequestMethod.GET)
    List<Produit> getAllProduits(){
        return produitService.getAllProduits();
    }
}
