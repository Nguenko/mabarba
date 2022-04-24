package com.project.mabarba.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


    @OneToOne(mappedBy = "carnet")
    private Coiffeur coiffeur;

    @OneToMany(mappedBy = "plagehoraireId")
    private List<PlageHoraire> plageHoraires;

}
