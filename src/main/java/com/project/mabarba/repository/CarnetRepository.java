package com.project.mabarba.repository;


import java.util.List;
import java.util.Optional;

import com.project.mabarba.models.Carnet;
import com.project.mabarba.models.Coiffeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {
    Optional<Carnet> findByIdAndDeletedIsFalse(Long id);

    List<Carnet> findAllByOrderByCreatedAtDesc();

    Page<Carnet> findAllByOrderByCreatedAtDesc(Pageable pageable);
}
