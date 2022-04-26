package com.project.mabarba.models;


import javax.persistence.*;

@Entity
public class Coiffeur {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private  String nom;

    private String telephone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @OneToOne
    @JoinColumn(name = "carnetId")
    private Carnet carnet;


    @ManyToOne
    @JoinColumn(name = "salonId")
    private  Salon salon;



}
