package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
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

    //Liste des coiffeurs d'un salon de coiffure
    /*List<Coiffeur> findAllByCoiffeursOrderByCreatedAtDesc();*/
    List<Coiffeur> findAllById(Long id);

    @Query(value="select * from coiffeur where salonId =:id ", nativeQuery=true)
    List<Coiffeur> getAllCoiffeursBySalonId(Long id);

    //recherche simple d'un salon
    @Query(value="select * from Salon s, Localisation l where l.ville=:townUser and l.quartier=:quarterUser", nativeQuery = true)
    List<Salon> searchAllSalonByUser(String townUser, String quarterUser);

    @Query(value="SELECT * FROM Salon INNER JOIN Localisation l ON Salon.localisation_id=Localisation.id and l.ville:=townUser and l.quartier:=quaterUser", nativeQuery = true)
    List<Salon> searchAllSalonsByUser(String townUser, String quarterUser);

    //Rechercher les salon par leur nom
    @Query(value = "SELECT * From Salon where name:=name", nativeQuery = true)
    List<Salon> searchAllSalonsByName(String name);
    //TODO: Terminer avec la reservation
    // TODO: Recherche par texte: salon, coiffures, coiffeur
}
