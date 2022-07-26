package com.project.mabarba.payload.request;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CoiffeurRequest {
    @NotBlank
    private String nom;

    @NotBlank
    private String telephone;

    @NotBlank
    private Long salonId;

    @Id
    private Long id;

    public CoiffeurRequest(long id, String nom,  String telephone) {
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
    }

    public CoiffeurRequest(String nom,  String telephone) {
        this.nom = nom;
        this.telephone = telephone;
    }

    public CoiffeurRequest(){}

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

    public Long getSalonId() {
        return salonId;
    }

    public void setSalonId(Long salonId) {
        this.salonId = salonId;
    }

}
