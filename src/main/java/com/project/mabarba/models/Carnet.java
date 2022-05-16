package com.project.mabarba.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "carnet")
public class Carnet extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom",  nullable = false)
    private String nom;

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


    @OneToOne(mappedBy = "carnet")
    private Coiffeur coiffeur;

    public Coiffeur getCoiffeur() {
        return coiffeur;
    }

    public void setCoiffeur(Coiffeur coiffeur) {
        this.coiffeur = coiffeur;
    }

    @OneToMany(mappedBy = "carnet")
    private List<PlageHoraire> plageHoraires;

    public List<PlageHoraire> getPlageHoraires() {
        return plageHoraires;
    }

    public void setPlageHoraires(List<PlageHoraire> plageHoraires) {
        this.plageHoraires = plageHoraires;
    }
}
