package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffeur;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.lang.annotation.Native;
import java.util.List;
import java.util.Optional;

@Repository
public interface CoiffeurRepository extends JpaRepository<Coiffeur,Long> {

    Optional<Coiffeur> findByIdAndDeletedIsFalse(long id);
    Coiffeur findByNom(String nom);
    List<Coiffeur> findAllByOrderByCreatedAtDesc();
    Page<Coiffeur> findAllByOrderByCreatedAtDesc(Pageable pageable);

    @Transactional
    @Modifying
    @Query(value="update Coiffeur c set c.deleted = :deleted where c.coiffeurId = :coiffeurId", nativeQuery = true)
    Optional<Coiffeur> deleteCoiffeurById(@Param("deleted")boolean deleted , @Param("coiffeurId")Long coiffeurId);

//    @Modifying
//    @Query("update User u set u.firstname = ?1, u.lastname = ?2 where u.id = ?3")
//    void setUserInfoById(String firstname, String lastname, Integer userId);

}
