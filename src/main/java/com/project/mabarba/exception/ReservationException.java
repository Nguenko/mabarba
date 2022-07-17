package com.project.mabarba.exception;

public class ReservationException extends Exception {
    long plageHoraireId;
    public ReservationException(long plageHoraireId){
        super(String.format("The plageHoraire with id : %s is unavailable",plageHoraireId));
    }
}
