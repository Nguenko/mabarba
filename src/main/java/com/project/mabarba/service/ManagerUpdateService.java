package com.project.mabarba.service;

import com.project.mabarba.models.Carnet;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Coiffure;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CarnetRequest;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.CoiffureRequest;
import com.project.mabarba.payload.request.SalonRequest;

public interface ManagerUpdateService {

    // ---------------------- Salon -----------------/
    // Create a salon
    Salon salonCreation(SalonRequest salonRequest);

    // update a salon
    Salon salonModification(SalonRequest salonRequest, Long id);

    /********************* Coiffeur ******************/
    // create a barber
    Coiffeur barberCreation(CoiffeurRequest coiffeurRequest);

    // update a barberbg
    Coiffeur barberModification(CoiffeurRequest coiffeurRequest, Long id);

    /**
     * Gestion des coiffures
     */

    //update a coiffure
    Coiffure coiffureModification(CoiffureRequest coiffureRequest, Long id);

    //Creation d'une coiffure
    Coiffure coiffureCreation(CoiffureRequest coiffureRequest);

    /**
     * Gestion des carnets
     */
    Carnet carnetCreation(CarnetRequest carnetRequest);

    Carnet carnetModification(CarnetRequest carnetRequest, Long id);
}
