package com.project.mabarba.repository;

import com.project.mabarba.MabarbaApplication;
import com.project.mabarba.models.Carnet;
import com.project.mabarba.models.PlageHoraire;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface PlageHoraireRepository extends JpaRepository<PlageHoraire, Long> {
    //Creer une plage horaire
    PlageHoraire save(PlageHoraire plageHoraire);
    //Modifier une plage horaire

    //Afficher une plage horaire
    //Optional<PlageHoraire>findByIdAndDeleteIsFalse(Long id);

    //Afficher la liste des plages horaires
    List<PlageHoraire>findAll();
    List<PlageHoraire>findAllByOrderByCreatedAtDesc();

    //Afficher les plages horaires par page
    Page<PlageHoraire>findAllByOrderByCreatedAtDesc (Pageable pageable);

    //Afficher les plages horaires d'un carnet
    List<PlageHoraire> findCarnetById(Long carnetId);

    //Afficher les plage horaires pour une journee x
    List<PlageHoraire> findAllByJourAndCarnetIdOrderByCreatedAtDesc(Date jour,Long carnetId);

}
