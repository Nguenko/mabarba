package com.project.mabarba.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "coiffure")
public class Coiffure extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "prix", nullable = true, updatable = true)
    private double prix;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "hh:mm:ss")
    @Column(
            name = "duree",
            nullable = false
    )
    private Date duree;

    public Coiffure(){

    }
    public Coiffure(String nom, double prix){

    }
    public Coiffure (Long id, String nom, double prix){

    }

    public Coiffure(String nom, double prix, Salon salon) {
        this.nom = nom;
        this.prix = prix;
        this.salon = salon;
    }

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


    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salonId")
    private Salon salon;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coiffure",cascade = CascadeType.ALL)
    List<File> photos = new ArrayList<>();
}
