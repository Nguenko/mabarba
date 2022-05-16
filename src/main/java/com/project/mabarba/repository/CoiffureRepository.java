package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffure;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoiffureRepository extends JpaRepository<Coiffure,Long> {
}
