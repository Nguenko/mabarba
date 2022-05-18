package com.project.mabarba.service;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.User;

public interface UserRetrieveService {
    //Display User information
    User userDisplayedByID(Long userId) throws NoDataFoundException;
    User userDisplayedByUserName(String username) throws NoDataFoundException;

    //Delete User
    //Boolean userDeleted(Long userId) throws NoDataFoundException;

    /******************List of Element *************/
    //Display all users information
    List<User> userDisplayedList();

    //Display users information by page
    Map<String, Object> userDisplayedPage(int pageNo, int pageSize);
}
