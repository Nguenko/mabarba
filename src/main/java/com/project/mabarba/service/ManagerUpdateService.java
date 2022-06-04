package com.project.mabarba.service;

import com.project.mabarba.models.*;
import com.project.mabarba.payload.request.*;
import org.springframework.stereotype.Service;

@Service
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

    /**
     * Gestion des plages horaires
     */
    //Création d'une plage horaire
    PlageHoraire plageHoraireCreation(PlageHoraireRequest plageHoraireRequest);

    //Modification d'une plage Horaire
    PlageHoraire plageHoraireModification(PlageHoraireRequest plageHoraireRequest, Long id);
}
