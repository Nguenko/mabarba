package com.project.mabarba.payload.request;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class PlageHoraireRequest {
    @Id
    private Long id;

    @NotBlank
    private String debut;

    @NotBlank
    private String fin;

    @NotBlank
    private Date jour;

    @NotBlank
    private Long carnetId;

    public PlageHoraireRequest() {
    }

    public PlageHoraireRequest(Long id, String debut, String fin, Date jour) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.jour = jour;
    }

    public PlageHoraireRequest(String debut, String fin, Date jour) {
        this.debut = debut;
        this.fin = fin;
        this.jour = jour;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDebut() {
        return debut;
    }

    public void setDebut(String debut) {
        this.debut = debut;
    }

    public String getFin() {
        return fin;
    }

    public void setFin(String fin) {
        this.fin = fin;
    }

    public Date getJour() {
        return jour;
    }

    public void setJour(Date jour) {
        this.jour = jour;
    }

    public Long getCarnetId() {
        return carnetId;
    }

    public void setCarnetId(Long carnetId) {
        this.carnetId = carnetId;
    }
}
