package com.project.mabarba.models;

import javax.persistence.*;

@Entity
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


    @OneToOne(mappedBy = "localisation")
    private Salon salon;


}
