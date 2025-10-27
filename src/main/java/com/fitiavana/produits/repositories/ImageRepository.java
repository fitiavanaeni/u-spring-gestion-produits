package com.fitiavana.produits.repositories;

import com.fitiavana.produits.entities.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Image, Long> {
}