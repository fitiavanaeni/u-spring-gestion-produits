package com.fitiavana.produits.services.impls;

import com.fitiavana.produits.entities.Categorie;
import com.fitiavana.produits.entities.Produit;
import com.fitiavana.produits.repositories.ImageRepository;
import com.fitiavana.produits.repositories.ProduitRepository;
import com.fitiavana.produits.services.ProduitService;
import dto.ProduitDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProduitServiceImpl implements ProduitService {

    @Autowired
    ProduitRepository produitRepository;

    @Autowired
    ImageRepository imageRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public ProduitDTO saveProduit(ProduitDTO produitDTO) {
        return convertEntityToDto(produitRepository.save(convertDtoToEntity(produitDTO)));
    }

    @Override
    public ProduitDTO updateProduit(ProduitDTO produitDTO) {
/*
        Long oldProdImageId = this.getProduit(p.getIdProduit()).getImage().getIdImage();
        Long newProdImageId = p.getImage().getIdImage();*/
        ProduitDTO prodUpdated = convertEntityToDto( produitRepository.save(convertDtoToEntity(produitDTO)));
        /*if (oldProdImageId != newProdImageId) //si l'image a été modifiée
            imageRepository.deleteById(oldProdImageId);*/
        return prodUpdated;

    }

    @Override
    public void deleteProduit(Produit p) {
        produitRepository.delete(p);
    }

    /*@Override
    public void deleteProduitById(Long id) {
        ProduitDTO p = getProduit(id);
        try {
            Files.delete(Paths.get(System.getProperty("user.home")+"/images/"+p.getImagePath()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        produitRepository.deleteById(id);

    }*/

    @Override
    public ProduitDTO getProduit(Long id) {
        return convertEntityToDto(produitRepository.findById(id).get());
    }

    @Override
    public List<ProduitDTO> getAllProduits() {
        return produitRepository.findAll().stream()
                .map(this::convertEntityToDto).
                collect(Collectors.toList());

            //OU BIEN
            /*List<Produit> prods = produitRepository.findAll();
            List<ProduitDTO> listprodDto = new ArrayList<>(prods.size());
            for (Produit p : prods)
            listprodDto.add(convertEntityToDto(p));
            return listprodDto;*/
    }

    @Override
    public List<Produit> findByNomProduit(String nom) {
        return produitRepository.findByNomProduit(nom);
    }

    @Override
    public List<Produit> findByNomProduitContains(String nom) {
        return produitRepository.findByNomProduitContains(nom);
    }

    @Override
    public List<Produit> findByNomPrix(String nom, Double prix) {
        return produitRepository.findByNomPrix(nom, prix);
    }

    @Override
    public List<Produit> findByCategorie(Categorie categorie) {
        return produitRepository.findByCategorie(categorie);
    }

    @Override
    public List<Produit> findByCategorieIdCat(Long id) {
        return produitRepository.findByCategorieIdCat(id);
    }

    @Override
    public List<Produit> findByOrderByNomProduitAsc() {
        return produitRepository.findByOrderByNomProduitAsc();
    }

    @Override
    public List<Produit> trierProduitsNomsPrix() {
        return produitRepository.trierProduitsNomsPrix();
    }

    @Override
    public ProduitDTO convertEntityToDto(Produit produit) {

        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
        ProduitDTO produitDTO = modelMapper.map(produit, ProduitDTO.class);

        return  produitDTO;
    /*    ProduitDTO produitDTO = new ProduitDTO();
        produitDTO.setIdProduit(produit.getIdProduit());
        produitDTO.setNomProduit(produit.getNomProduit());
        produitDTO.setPrixProduit(produit.getPrixProduit()); produitDTO.setDateCreation(p.getDateCreation());
        produitDTO.setCategorie(produit.getCategorie());
        return produitDTO;*/

        /*
        return ProduitDTO.builder()
        .idProduit(produit.getIdProduit())
        .nomProduit(produit.getNomProduit())
        .prixProduit(produit.getPrixProduit())
        .dateCreation(produit.getDateCreation())
        .categorie(produit.getCategorie())
        .build();
         */
    }

    @Override
    public Produit convertDtoToEntity(ProduitDTO produitDto) {
        Produit produit = new Produit();
        produit = modelMapper.map(produitDto, Produit.class);
        return  produit;

        /*
        produit.setIdProduit(produitDto.getIdProduit());
        produit.setNomProduit(produitDto.getNomProduit());
        produit.setPrixProduit(produitDto.getPrixProduit());
        produit.setDateCreation(produitDto.getDateCreation());
        produit.setCategorie(produitDto.getCategorie());
        return produit;
         */
    }
}