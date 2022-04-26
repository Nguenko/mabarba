package com.project.mabarba.models;

import javax.persistence.*;
import java.util.List;

@Entity
public class PlageHoraire {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

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


}
