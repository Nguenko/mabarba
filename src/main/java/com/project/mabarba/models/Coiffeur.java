package com.project.mabarba.models;


import javax.persistence.*;

@Entity
public class Coiffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;

    @OneToOne
    @JoinColumn(name = "carnetId")
    private Carnet carnet;


    @ManyToOne
    @JoinColumn(name = "salonId")
    private  Salon salon;
}
