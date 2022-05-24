package com.project.mabarba.service.impl;

import com.project.mabarba.models.User;
import com.project.mabarba.payload.request.SignupRequest;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.UserUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UserUpdateImpl implements UserUpdateService {
    @Autowired
    UserRepository userRepository;

    @Override
    public User userModification(SignupRequest signupRequest, Long id){
        Supplier<User> user = ()->new User(id,signupRequest.getUsername(), signupRequest.getEmail());
        return userRepository.save(user.get());
    }
}
