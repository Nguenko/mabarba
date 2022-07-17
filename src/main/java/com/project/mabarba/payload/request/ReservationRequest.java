package com.project.mabarba.payload.request;

import com.project.mabarba.models.EStatutReservation;

import javax.validation.constraints.NotBlank;

public class ReservationRequest {
    private Long id;

    @NotBlank
    private Long plageHoraireId;

    @NotBlank
    private Long userId;

    @NotBlank
    private EStatutReservation statut;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlageHoraireId() {
        return plageHoraireId;
    }

    public void setPlageHoraireId(Long plageHoraireId) {
        this.plageHoraireId = plageHoraireId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public EStatutReservation getStatut() {
        return statut;
    }

    public void setStatut(EStatutReservation statut) {
        this.statut = statut;
    }
}
