package com.project.mabarba.models;


import javax.persistence.*;
import java.util.ArrayList;
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


    @ManyToOne
    @JoinColumn(name = "salonId")
    private Salon salon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coiffure",cascade = CascadeType.ALL)
    List<File> photos = new ArrayList<>();
}
