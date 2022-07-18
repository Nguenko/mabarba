package com.project.mabarba.service.impl;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.exception.ReservationException;
import com.project.mabarba.models.*;
import com.project.mabarba.payload.request.ReservationRequest;
import com.project.mabarba.payload.request.SignupRequest;
import com.project.mabarba.repository.PlageHoraireRepository;
import com.project.mabarba.repository.ReservationRepository;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UserUpdateImpl implements UserUpdateService {
    @Autowired
    UserRepository userRepository;

    @Autowired
    PlageHoraireRepository plageHoraireRepository;

    @Autowired
    ReservationRepository reservationRepository;

    @Override
    public User userModification(SignupRequest signupRequest, Long id){
        Supplier<User> user = ()->new User(id,signupRequest.getUsername(), signupRequest.getEmail());
        return userRepository.save(user.get());
    }

    @Override
    public Reservation userCreateReservation(ReservationRequest reservationRequest) throws ReservationException, NoDataFoundException{
        User user = userRepository.getById(reservationRequest.getUserId());
        PlageHoraire plageHoraire = plageHoraireRepository.findByIdAndDeletedIsFalse(reservationRequest.getPlageHoraireId()).orElseThrow(()->new NoDataFoundException(reservationRequest.getPlageHoraireId()));
        Reservation reservation = new Reservation(user,plageHoraire);

        if(plageHoraire.getEtat().equals(EEtat.NON_RESERVEE) && !reservationRequest.getStatut().equals(EStatutReservation.REGLE)){
            plageHoraire.setEtat(EEtat.RESERVEE_DISPONIBLE);
            plageHoraireRepository.save(plageHoraire);
            reservation.setStatut(EStatutReservation.NON_REGLE);
            reservation = reservationRepository.save(reservation);
        }
        else if((plageHoraire.getEtat().equals(EEtat.RESERVEE_DISPONIBLE)||
                plageHoraire.getEtat().equals(EEtat.NON_RESERVEE)) &&
                        reservationRequest.getStatut().equals(EStatutReservation.REGLE)
        ){
            if(plageHoraire.getEtat().equals(EEtat.RESERVEE_DISPONIBLE)){
                //Quelqu'un avait déjà reservé. on lui envoie un message pour lui informer de l'annulation
                //TODO: Suprimer l'ancienne reservation et envoie du message
                //TODO: Envoie du mail pour informé de l'annulation de sa reservation
            }
            plageHoraire.setEtat(EEtat.RESERVEE_INDISPONIBLE);
            reservation.setStatut(EStatutReservation.REGLE);
            reservation = reservationRepository.save(reservation);
        }
        else if(plageHoraire.getEtat().equals(EEtat.RESERVEE_INDISPONIBLE)){
            throw new ReservationException(plageHoraire.getId());
        }
        else{
            throw new ReservationException(plageHoraire.getId());
        }
        return reservation;
    }

}
