package com.project.mabarba.payload.request;

import javax.validation.constraints.NotBlank;

public class SalonRequest {

    @NotBlank
    private String nom;

    @NotBlank
    private String telephone;

    private Long id;

    public SalonRequest(String nom,  String telephone) {
        this.nom = nom;
        this.telephone = telephone;
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
