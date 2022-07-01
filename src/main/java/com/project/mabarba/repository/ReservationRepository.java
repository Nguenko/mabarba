package com.project.mabarba.repository;

import com.project.mabarba.models.Reservation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation, Long>, PagingAndSortingRepository<Reservation,Long> {

    Reservation save(Reservation reservation);

    Page<Reservation> findAllByOrderByCreatedAtDesc(Pageable pageable);

    //Optional<Reservation> findByIdAndDeletedIsFalse(Long id);

    @Query(value = "select * from Reservation R, PlageHoraire P, Coiffeur C where R.plage_horaire_id=P.id and P.carnet_id=C.carnet_id and C.id=:coiffeurId", nativeQuery = true)
    List<Reservation> getBarberReservation(Long coiffeurId);



}
