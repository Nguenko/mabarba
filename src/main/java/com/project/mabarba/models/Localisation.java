package com.project.mabarba.models;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name = "localisation")
public class Localisation extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "quartier", nullable = false)
    private String quartier;

    @Column(name = "ville", nullable = false)
    private String ville;

    public Long getId() {
        return id;
    }

    public void setId(Long localisationId) {
        this.id = localisationId;
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

    @JsonIgnore
    @OneToOne(mappedBy = "localisation")
    private Salon salon;


}
