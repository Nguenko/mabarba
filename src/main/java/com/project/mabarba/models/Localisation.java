package com.project.mabarba.models;

import javax.persistence.*;

@Entity
public class Localisation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String quartier;

    private String ville;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getQuartier() {
        return quartier;
    }

    public void setQuartier(String quartier) {
        this.quartier = quartier;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }


    @OneToOne(mappedBy = "localisation")
    private Salon salon;


}
