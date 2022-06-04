package com.project.mabarba.service;

import com.project.mabarba.models.User;
import com.project.mabarba.payload.request.SignupRequest;
import org.springframework.stereotype.Service;

@Service
public interface UserUpdateService {
    //update a user
    User userModification(SignupRequest signupRequest, Long id);

    //TODO: Reserver une plage Horaire
}
