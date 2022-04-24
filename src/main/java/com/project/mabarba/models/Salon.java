package com.project.mabarba.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Salon {

    @NotBlank
    private String name;



    public Salon(){

    }

    @OneToOne
    @JoinColumn(name = "localisationId")
    private Localisation localisation;


    @OneToMany(mappedBy = "salon")
    private List<Coiffure> coiffures;

    @OneToMany(mappedBy = "salon")
    private  List<Coiffeur> coiffeurs;

    @ManyToMany
    @JoinTable(name = "paiement", joinColumns = @JoinColumn(name = "salon_id"), inverseJoinColumns =
    @JoinColumn(name = "user_id"))
    private List<User> users;


}
