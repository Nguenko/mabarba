package com.project.mabarba.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlageHoraire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String id;



    @ManyToOne
    @JoinColumn(name = "carnetId")
    private Carnet carnet;


    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "reservation",
            joinColumns = @JoinColumn(name = "plage_id"),
            inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList;


}
