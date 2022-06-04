package com.project.mabarba.service;

import java.util.List;
import java.util.Map;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.*;
import org.springframework.stereotype.Service;

@Service
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

    //Liste des Coiffeurs d'un salon
    List<Coiffeur> salonDisplayedCoiffeur(long salonId) throws NoDataFoundException;

    //Liste des coiffures d'un salon
    List<Coiffure> salonDisplayedCoiffure(long salonId) throws NoDataFoundException;

    /*************** Coiffeur *****************/
    // Display a barba information
    Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException;

    // Delete a barber information
    boolean barberDeleted(long coiffeurId) throws NoDataFoundException;

    // ------------------------------List of ellements
    // ----------------------------------

    // Display a barba information
    List<Coiffeur> barberDisplayedList();

    // ------------------------------Page of elements
    // ----------------------------------

    // Display a barba information
    Map<String, Object> barberDisplayedPage(int pageNo, int pageSize);

    /**
     * Gestion des coiffures
     */
    //Display a Coiffure information
    Coiffure coiffureDisplayed(long coiffureId) throws NoDataFoundException;

    //Delete a coiffure information
    boolean coiffureDeleted(long coiffureId) throws NoDataFoundException;

    //--------------------- List of Coiffure

    //Display all coiffure information
    List<Coiffure> coiffureDisplayedList();

    //----------------- Page of elements --------------------------------
    //Display a coiffure information
    Map<String, Object> coiffureDisplayedPage(int pageNo, int pageSize);

    /**
     * Gestion des carnets
     */
    // Display one carnet
    Carnet carnetDisplayed(long carnetId) throws NoDataFoundException;

    // Display list of carnet
    List <Carnet> carnetDisplayedList();

    // Display list of carnet by page
    Map<String, Object> carnetDisplayedPage(int pageNo, int pageSize);

    /**
     * Gestion des plages horaires
     */
    //Afficher une plage horaire
    PlageHoraire plageHoraireDisplayed(long plageId) throws NoDataFoundException;
    //Afficher la liste des plages horaires
    List<PlageHoraire>plageHoraireDisplayedList();
    //Afficher les plages horaires par pages
    Map<String,Object> plageHoraireDisplayedPage(int pageNo, int pageSize);

    //Afficher les plages horaires d'un carnet

}
