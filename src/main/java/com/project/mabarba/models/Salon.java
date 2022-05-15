package com.project.mabarba.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "Salon")
public class Salon extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;

    @Column(name = "telephone", nullable = false)
    private String telephone;


    @OneToMany(fetch = FetchType.LAZY, mappedBy = "salon", cascade = CascadeType.ALL)
    List<File> photos = new ArrayList<>();


    public Salon(){

    }



    public Salon(String nom, String telephone){
        this.nom =  nom;
        this.telephone =  telephone;
    }

    public Salon(Long id, String nom, String telephone){
        this.id = id;
        this.nom =  nom;
        this.telephone =  telephone;
    }


    public Salon(Long id, String nom, String telephone, boolean deleted){
        this.id = id;
        this.nom =  nom;
        this.telephone =  telephone;
        super.deleted = deleted;
    }

    public Salon(Long id, String nom, String telephone, boolean deleted, Date createdAt){
        this.id = id;
        this.nom =  nom;
        this.telephone =  telephone;
        super.deleted = deleted;
        super.createdAt = createdAt;
    }

    public Salon(Salon salon) {
        this.id = salon.getId();
        this.nom =  salon.getNom();
        this.telephone = salon.getTelephone();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return nom;
    }

    public void setName(String name) {
        this.nom = name;
    }

    @OneToOne(cascade = {CascadeType.ALL})
    @JoinColumn(name = "localisationId")
    private Localisation localisation;


    @OneToMany(mappedBy = "salon", cascade = CascadeType.ALL)
    private List<Coiffure> coiffures;

    @OneToMany(mappedBy = "salon")
    private  List<Coiffeur> coiffeurs;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "paiement", joinColumns = @JoinColumn(name = "salon_id"), inverseJoinColumns =
    @JoinColumn(name = "user_id"))
    private List<User> users;

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Localisation getLocalisation() {
        return localisation;
    }

    public void setLocalisation(Localisation localisation) {
        this.localisation = localisation;
    }

    public List<Coiffure> getCoiffures() {
        return coiffures;
    }

    public void setCoiffures(List<Coiffure> coiffures) {
        this.coiffures = coiffures;
    }

    public List<Coiffeur> getCoiffeurs() {
        return coiffeurs;
    }

    public void setCoiffeurs(List<Coiffeur> coiffeurs) {
        this.coiffeurs = coiffeurs;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
}
