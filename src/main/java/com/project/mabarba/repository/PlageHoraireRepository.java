package com.project.mabarba.repository;

import com.project.mabarba.models.PlageHoraire;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlageHoraireRepository extends JpaRepository<PlageHoraire, Long> {
}
