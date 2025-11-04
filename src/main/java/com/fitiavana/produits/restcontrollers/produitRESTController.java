package com.fitiavana.produits.restcontrollers;

import com.fitiavana.produits.entities.Produit;
import com.fitiavana.produits.services.ProduitService;
import dto.ProduitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin
public class produitRESTController {

    @Autowired
    private ProduitService produitService;

    @RequestMapping(path = "/all", method = RequestMethod.GET)
    public List<ProduitDTO> getAllProduits() {
        return produitService.getAllProduits();
    }

    @RequestMapping(value = "/getbyid/{id}", method = RequestMethod.GET)
    public ProduitDTO getProduitById(@PathVariable("id") Long id) {
        return produitService.getProduit(id);
    }

    @RequestMapping(path = "/addprod", method = RequestMethod.POST)
    public ProduitDTO createProduit(@RequestBody ProduitDTO produit) {
        return produitService.saveProduit(produit);
    }

    @RequestMapping(path = "/updateprod", method = RequestMethod.PUT)
    public ProduitDTO updateProduit(@RequestBody ProduitDTO produit) {
        return produitService.updateProduit(produit);
    }

   /* @RequestMapping(value = "/delprod/{id}", method = RequestMethod.DELETE)
    public void deleteProduit(@PathVariable("id") Long id) {
        produitService.deleteProduitById(id);
    }*/

    @RequestMapping(value = "/prodscat/{idCat}", method = RequestMethod.GET)
    public List<Produit> getProduitsByCatId(@PathVariable("idCat") Long idCat) {
        return produitService.findByCategorieIdCat(idCat);
    }

    @RequestMapping(value = "/prodsByName/{nom}", method = RequestMethod.GET)
    public List<Produit> findByNomProduitContains(@PathVariable("nom") String nom) {
        return produitService.findByNomProduitContains(nom);
    }

}
