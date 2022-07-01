package com.project.mabarba.service;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Reservation;
import com.project.mabarba.models.User;
import com.project.mabarba.payload.request.ReservationRequest;
import com.project.mabarba.payload.request.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserUpdateService {
    //update a user
    User userModification(SignupRequest signupRequest, Long id);

    Reservation userCreateReservation(ReservationRequest reservationRequest) throws NoDataFoundException, Exception;
}
