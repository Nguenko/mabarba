package com.project.mabarba.payload.request;

import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import java.util.Date;

public class PlageHoraireRequest {
    @Id
    private Long id;

    @NotBlank
    private Date debut;

    @NotBlank
    private Date fin;

    @NotBlank
    private Date jour;

    @NotBlank
    private Long carnetId;

    public PlageHoraireRequest() {
    }

    public PlageHoraireRequest(Long id, Date debut, Date fin, Date jour) {
        this.id = id;
        this.debut = debut;
        this.fin = fin;
        this.jour = jour;
    }

    public PlageHoraireRequest(Date debut, Date fin, Date jour) {
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

    public Long getCarnetId() {
        return carnetId;
    }

    public void setCarnetId(Long carnetId) {
        this.carnetId = carnetId;
    }
}
