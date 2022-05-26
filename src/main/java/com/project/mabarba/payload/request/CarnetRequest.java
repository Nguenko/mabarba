package com.project.mabarba.payload.request;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

public class CarnetRequest {
    @Id
    private Long id;
    @NotBlank
    private String nom;

    public String getNom(){
        return this.nom;
    }
    public void setNom(String nom){
        this.nom = nom;
    }
    public Long getId(){
        return this.id;
    }
    public void setId(Long id){
        this.id = id;
    }
}
