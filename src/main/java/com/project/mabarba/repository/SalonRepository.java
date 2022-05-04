package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SalonRepository extends JpaRepository<Salon, Long> {
    Optional<Salon> findByIdAndDeletedIsFalse(long id);
    List<Salon> findAllByIdAndDeletedIsFalse(long id);
    //Optional<Share> findByUserIdAndOfferIdAndDeletedIsFalse(String userId, String offerId);
}
