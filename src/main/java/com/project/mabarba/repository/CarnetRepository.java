package com.project.mabarba.repository;


import java.util.List;
import java.util.Optional;

import com.project.mabarba.models.Carnet;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.PlageHoraire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {

    Carnet save(Carnet carnet);

    Optional<Carnet> findByIdAndDeletedIsFalse(Long id);

    List<Carnet> findAll();

    List<Carnet> findAllByOrderByCreatedAtDesc();

    Page<Carnet> findAllByOrderByCreatedAtDesc(Pageable pageable);


    //Afficher le carnet d'un coiffeur
    Optional<Carnet> findByCoiffeurIdAAndDeletedIsFalse(Long coiffeurId);
}
