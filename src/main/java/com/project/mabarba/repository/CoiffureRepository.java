package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffure;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoiffureRepository extends JpaRepository<Coiffure,Long> {
    Optional<Coiffure> findByIdAndDeletedIsFalse(long id);
    Coiffure save(Coiffure coiffure);

    List<Coiffure> findAll();

    List<Coiffure> findAllByOrderByCreatedAtDesc();

    Page<Coiffure> findAllByOrderByCreatedAtDesc(Pageable pageable);

    //Liste des coiffures d'un salon
    List<Coiffure> findBySalonId(Long salonId);
}
