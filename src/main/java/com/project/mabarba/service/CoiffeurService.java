package com.project.mabarba.service;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.payload.request.CoiffeurRequest;

public interface CoiffeurService {
    /*************** Retrive Service *****************/
    // Display a barba information
    /**
     * Display a barba information
     * @param coiffeurId
     * @return
     */
    Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException;

    /**
     * Delete a barber information
     * @param coiffeurId
     * @return
     */
    boolean barberDeleted(long coiffeurId) throws NoDataFoundException;

    // ------------------------------List of ellements
    // ----------------------------------

    // Display a barba information
    List<Coiffeur> barberDisplayedList();

    // ------------------------------Page of ellements
    // ----------------------------------

    // Display a barba information
    /**
     * paginated list of barber
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map<String, Object> barberDisplayedPage(int pageNo, int pageSize);

    /********************* Update Service  ******************/
    //create a barber
    Coiffeur barberCreation(CoiffeurRequest coiffeurRequest);

    //update a barberbg
    /**
     * paginated list of barber
     * @param coiffeurRequest
     * @param id
     * @return
     */
    Coiffeur barberModification(CoiffeurRequest coiffeurRequest, Long id);
}
