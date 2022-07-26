package com.project.mabarba.exception;

public class ReservationException extends Exception {
    long plageHoraireId;
    long coiffureId;
    public ReservationException(long plageHoraireId){
        super(String.format("The plageHoraire with id : %s is unavailable",plageHoraireId));
    }
    public ReservationException(long plageHoraireId, long coiffureId){
        super(String.format("The duration of the hairstyle with id :%s is greater than the duration of the range with %s",coiffureId,plageHoraireId));
    }
    public ReservationException(String durationOfPlage){
        super(String.format("This hairstyle requires at least %s to be achieved", durationOfPlage));
    }
}
