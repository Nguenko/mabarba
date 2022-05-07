package com.project.mabarba.repository;

import com.project.mabarba.models.Coiffeur;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

@DataJpaTest
class CoiffeurRepositoryTest {

    @Autowired
    private CoiffeurRepository coiffeurRepository;

    @AfterEach
    void tearDown(){
        coiffeurRepository.deleteAll();
    }

    @Test
    void findByIdAndDeletedIsFalse() throws Exception{
        //given
       // String nom ="Stevenson";

       // Coiffeur coiffeur = new Coiffeur(nom,"674253980");

        //coiffeurRepository.save(coiffeur);

        //when
        //Coiffeur coif = coiffeurRepository.findByNom(nom);

        //then
        //assertThat(coiffeur.getNom()).isEqualTo(nom);

    }
}