package com.project.mabarba.service;

import com.project.mabarba.exception.NoDataFoundException;
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

    Boolean salonDelete(Long salonId) throws NoDataFoundException;

    /********************* Coiffeur ******************/
    // create a barber
    Coiffeur barberCreation(CoiffeurRequest coiffeurRequest) throws NoDataFoundException;

    // update a barberbg
    Coiffeur barberModification(CoiffeurRequest coiffeurRequest, Long id);

    Boolean barberDelete(Long coiffeurId) throws NoDataFoundException;

    /**
     * Gestion des coiffures
     */
    Coiffure coiffureModification(CoiffureRequest coiffureRequest, Long id);
    Coiffure coiffureCreation(CoiffureRequest coiffureRequest);
    Boolean coiffureDelete(Long coiffureId) throws NoDataFoundException;

    /**
     * Gestion des carnets
     */
    Carnet carnetCreation(CarnetRequest carnetRequest);
    Carnet carnetModification(CarnetRequest carnetRequest, Long id);
    Boolean carnetDelete(Long carnetId) throws NoDataFoundException;
    /**
     * Gestion des plages horaires
     */
    //Création d'une plage horaire
    PlageHoraire plageHoraireCreation(PlageHoraireRequest plageHoraireRequest);

    //Modification d'une plage Horaire
    PlageHoraire plageHoraireModification(PlageHoraireRequest plageHoraireRequest, Long id);

    Boolean plageHoraireDelete(Long plageHoraireId) throws NoDataFoundException;
}
