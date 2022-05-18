package com.project.mabarba.service;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;

public interface ManagerRetrieveService {
    /**************** Salon ***********************/
    // ----------------------- RetrieveService salon ---------------/

    // Display a salon information
    Salon salonDisplayed(long salonId) throws NoDataFoundException;

    // Delete a salon information
    boolean salonDeleted(long salonId) throws NoDataFoundException;

    // ------------------------------List of ellements
    // ----------------------------------
    // Display a salon information
    List<Salon> salonDisplayedList();

    // ------------------------------Page of ellements
    // ----------------------------------
    // Display a salon information
    Map<String, Object> salonDisplayedPage(int pageNo, int pageSize);

    /*************** Coiffeur *****************/
    // Display a barba information
    Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException;

    // Delete a barber information
    boolean barberDeleted(long coiffeurId) throws NoDataFoundException;

    // ------------------------------List of ellements
    // ----------------------------------

    // Display a barba information
    List<Coiffeur> barberDisplayedList();

    // ------------------------------Page of ellements
    // ----------------------------------

    // Display a barba information
    Map<String, Object> barberDisplayedPage(int pageNo, int pageSize);
}
