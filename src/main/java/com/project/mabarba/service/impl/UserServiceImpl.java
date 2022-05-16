package com.project.mabarba.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.User;
import com.project.mabarba.payload.request.SignupRequest;
import com.project.mabarba.repository.UserRepository;
import com.project.mabarba.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    /******** Retrive Service implement */
    @Override
    public User userDisplayedByID(Long userId) throws NoDataFoundException {
        return userRepository.findById(userId).orElseThrow(() -> new NoDataFoundException(userId));
    }

    @Override
    public User userDisplayedByUserName(String username) throws NoDataFoundException {
        return userRepository.findByUsername(username).orElseThrow(() -> new NoDataFoundException("User"));
    }

    /*
     * @Override
     * public Boolean userDeleted(Long userId) throws NoDataFoundException{
     * 
     * }
     */

    @Override
    public List<User> userDisplayedList() {
        Supplier<List<User>> userList = () -> userRepository.findAllByOrderByCreatedAtDesc();
        return userList.get();
    }

    @Override
    public Map<String, Object> userDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<User> userPage = userRepository.findAllByOrderByCreatedAtDesc(pageable);
            // on appel la mathode utilitaire qui gere la pagination
            return new FunctionalUtilities<User>().paginator(userPage);
        } catch (Exception e) {
            e.getMessage();
        }

        return null;
    }

    @Override
    public User userModification(SignupRequest signupRequest, Long id){
        Supplier<User> user = ()->new User(id,signupRequest.getUsername(), signupRequest.getEmail());
        return userRepository.save(user.get());
    }
}
