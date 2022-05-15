package com.project.mabarba.repository;

import com.project.mabarba.models.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long>, PagingAndSortingRepository<Salon, Long> {
    Optional<Salon> findByIdAndDeletedIsFalse(long id);
    Salon save(Salon salon);
    Salon findById(long id);
    boolean findByNom(String nom);
    List<Salon> findAll();
    List<Salon> findAllByOrderByCreatedAtDesc();
    Page<Salon> findAllByOrderByCreatedAtDesc(Pageable pageable);
 // Page<Offer> findAllByOrderByIdDesc(Pageable pageable);
 // Optional<Share> findByUserIdAndOfferIdAndDeletedIsFalse(String userId, String offerId);
}
