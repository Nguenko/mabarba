package com.project.mabarba.models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonView;
import com.project.mabarba.helpers.Scope;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Reservation extends CommonModel {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "plageHoraireId")
    private PlageHoraire plageHoraire;

    @Enumerated(EnumType.STRING)
    @Column(length = 20, columnDefinition = "varchar(20) default 'NON_REGLE'")
    private EStatutReservation statut;



    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public EStatutReservation getStatut() {
        return statut;
    }

    public void setStatut(EStatutReservation statut) {
        this.statut = statut;
    }

    public PlageHoraire getPlageHoraire() {
        return plageHoraire;
    }

    public void setPlageHoraire(PlageHoraire plageHoraire) {
        this.plageHoraire = plageHoraire;
    }

    public Reservation(User user, PlageHoraire plageHoraire) {
        this.user = user;
        this.plageHoraire = plageHoraire;
    }

    public Reservation(User user, PlageHoraire plageHoraire, EStatutReservation statut) {
        this.user = user;
        this.plageHoraire = plageHoraire;
        this.statut = statut;
    }
}
