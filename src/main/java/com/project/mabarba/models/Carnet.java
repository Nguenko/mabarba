package com.project.mabarba.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class Carnet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String nomCarnet;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomCarnet() {
        return nomCarnet;
    }

    public void setNomCarnet(String nomCarnet) {
        this.nomCarnet = nomCarnet;
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

}
