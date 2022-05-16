package com.project.mabarba.service;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.SalonRequest;

public interface SalonService {
    //----------------------- RetrieveService
    
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

    // ---------------------- Update Service
    //Create a salon
    Salon salonCreation(SalonRequest salonRequest);

    //update a salon
    Salon salonModification(SalonRequest salonRequest, Long id);
}
