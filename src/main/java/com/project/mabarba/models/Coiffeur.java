package com.project.mabarba.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "coiffeur")
public class Coiffeur extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "nom",
            nullable = false
    )
    private  String nom;
    @Column(
            name = "telephone",
            nullable = false
    )
    private String telephone;

    public Coiffeur(){

    }

    public Coiffeur(String nom, String telephone){
        this.nom = nom;
        this.telephone = telephone;
    }

    public Coiffeur(Long id, String nom, String telephone){
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
    }

    public Coiffeur(Long id, String nom, String telephone, boolean deleted, Date createdAt){
        this.id = id;
        this.nom = nom;
        this.telephone = telephone;
        super.deleted = deleted;
        super.createdAt = createdAt;
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

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @JsonIgnore
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carnetId")
    private Carnet carnet;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "salonId")
    private  Salon salon;

    @JsonIgnore
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coiffeur",cascade = CascadeType.ALL)
    List<File> photos = new ArrayList<>();

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

    public Salon getSalon() {
        return salon;
    }

    public void setSalon(Salon salon) {
        this.salon = salon;
    }
}
