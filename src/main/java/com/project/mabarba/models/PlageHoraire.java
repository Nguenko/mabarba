package com.project.mabarba.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "plageHoraire")
public class PlageHoraire extends CommonModel{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "hh:mm:ss")
    @Column(
            name = "debut",
            nullable = false
    )
    private Date debut;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "hh:mm:ss")
    @Column(
            name = "fin",
            nullable = false
    )
    private Date fin;

    @Enumerated(EnumType.STRING)
    @Column(length = 30, columnDefinition = "varchar(20) default 'NON_RESERVEE'")
    private EEtat etat;

    public EEtat getEtat() {
        return etat;
    }

    public void setEtat(EEtat etat) {
        this.etat = etat;
    }

    public Date getDebut() {
        return debut;
    }

    public void setDebut(Date debut) {
        this.debut = debut;
    }

    public Date getFin() {
        return fin;
    }

    public void setFin(Date fin) {
        this.fin = fin;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column(
            name = "jour",
            nullable = false
    )
    private Date jour;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "carnetId")
    private Carnet carnet;

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }


    @JsonIgnore
    @OneToMany(mappedBy = "plageHoraire")
   private List<Reservation> reservationList;

    public PlageHoraire() {
    }

    public PlageHoraire(Long id, Date debut, Date fin, Date jour) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.jour = jour;
    }

    public PlageHoraire(Date debut, Date fin, Date jour) {
        this.debut = debut;
        this.fin = fin;
        this.jour = jour;
    }
}
