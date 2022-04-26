package com.project.mabarba.models;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.List;

@Entity
public class Salon {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    private String name;



    public Salon(){

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @OneToOne
    @JoinColumn(name = "localisationId")
    private Localisation localisation;


    @OneToMany(mappedBy = "salon")
    private List<Coiffure> coiffures;

    @OneToMany(mappedBy = "salon")
    private  List<Coiffeur> coiffeurs;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "paiement", joinColumns = @JoinColumn(name = "salon_id"), inverseJoinColumns =
    @JoinColumn(name = "user_id"))
    private List<User> users;


}
