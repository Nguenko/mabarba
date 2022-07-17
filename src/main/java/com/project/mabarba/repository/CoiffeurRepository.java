package com.project.mabarba.repository;

import com.project.mabarba.models.Carnet;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Coiffure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoiffeurRepository extends JpaRepository<Coiffeur,Long> {

    Optional<Coiffeur> findByIdAndDeletedIsFalse(long id);
    Coiffeur findByNom(String nom);
    List<Coiffeur> findAllByOrderByCreatedAtDesc();
    Page<Coiffeur> findAllByOrderByCreatedAtDesc(Pageable pageable);

    //Liste des Coiffeurs d'un salon
    List<Coiffeur> findBySalonId(Long salonId);

    //Rechercher les salon par leur nom
    @Query(value = "SELECT * From Coiffeur where name:=name", nativeQuery = true)
    List<Coiffeur> searchAllCoiffeursByName(String name);
}
