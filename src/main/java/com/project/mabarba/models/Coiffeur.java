package com.project.mabarba.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;

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

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "carnetId")
    private Carnet carnet;


    @ManyToOne
    @JoinColumn(name = "salonId")
    private  Salon salon;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "coiffeur",cascade = CascadeType.ALL)
    List<File> photos = new ArrayList<>();


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Coiffeur)) return false;
        Coiffeur coiffeur = (Coiffeur) o;
        return Objects.equals(id, coiffeur.id) &&
                Objects.equals(nom, coiffeur.nom) &&
                Objects.equals(telephone, coiffeur.telephone);

    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, telephone);
    }

    @Override
    public String toString() {
        return "Coiffeur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }
}
