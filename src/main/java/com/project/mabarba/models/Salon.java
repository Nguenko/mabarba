package com.project.mabarba.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "Salon")
public class Salon extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(
            name = "nom",
            nullable = false
    )
    private String nom;



    public Salon(){

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
    @JoinColumn(name = "localisation_Id", referencedColumnName = "localisationId")
    private Localisation localisation;


    @OneToMany(mappedBy = "salon")
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
}
