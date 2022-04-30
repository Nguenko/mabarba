package com.project.mabarba.models;


import javax.persistence.*;

@Entity
@Table(name = "coiffeur")
public class Coiffeur extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "nom",
            nullable = false
    )
    private  String nom;

    @Column(
            name = "telephone",
            nullable = false
    )
    private String telephone;


    @Column(
            name = "matricule",
            nullable = true
    )
    private  String matricule;

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
