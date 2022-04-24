package com.project.mabarba.models;


import javax.persistence.*;

@Entity
public class Coiffure {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;


    @ManyToOne
    @JoinColumn(name = "salonId")
    private Salon salon;
}
