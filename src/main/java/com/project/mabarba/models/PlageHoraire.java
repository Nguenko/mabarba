package com.project.mabarba.models;

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

    @ManyToOne
    @JoinColumn(name = "carnetId")
    private Carnet carnet;

    public Carnet getCarnet() {
        return carnet;
    }

    public void setCarnet(Carnet carnet) {
        this.carnet = carnet;
    }

   @ManyToMany(fetch = FetchType.LAZY)
   @JoinTable(name = "reservation",
            joinColumns = @JoinColumn(name = "plage_id"),
           inverseJoinColumns = @JoinColumn(name = "user_id"))
   private List<User> userList;

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
