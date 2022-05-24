package com.project.mabarba.payload.request;

import com.project.mabarba.models.Coiffure;

import javax.validation.constraints.NotBlank;

public class CoiffureRequest {

    private Long id;

    @NotBlank
    private String nom;

    @NotBlank
    private double prix;

    public  CoiffureRequest(String nom, double prix){
        this.nom = nom;
        this.prix = prix;
    }

    public  CoiffureRequest(Long id, String nom, double prix){
        this.id = id;
        this.nom = nom;
        this.prix = prix;
    }

    public Long getId(){
        return id;
    }
    public String getNom(){
        return nom;
    }
    public double getPrix(){
        return prix;
    }

    public void setId(Long id){
        this.id = id;
    }
    public void setNom(String nom){
        this.nom= nom;
    }
    public void setPrix(double prix){
        this.prix = prix;
    }
}
