package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CoiffeurRepository extends JpaRepository<Coiffeur,Long> {

    Optional<Coiffeur> findByIdAndDeletedIsFalse(long id);
    List<Coiffeur> findAllByIdAndDeletedIsFalse(long id);
}
