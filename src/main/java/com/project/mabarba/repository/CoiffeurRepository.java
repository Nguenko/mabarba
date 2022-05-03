package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffeur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoiffeurRepository extends JpaRepository<Coiffeur,Long> {
}
