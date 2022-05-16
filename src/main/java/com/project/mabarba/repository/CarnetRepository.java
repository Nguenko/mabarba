package com.project.mabarba.repository;


import com.project.mabarba.models.Carnet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarnetRepository extends JpaRepository<Carnet, Long> {
}
