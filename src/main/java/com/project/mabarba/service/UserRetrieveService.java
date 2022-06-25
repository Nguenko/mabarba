package com.project.mabarba.service;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.prefs.NodeChangeEvent;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.models.*;
import org.springframework.stereotype.Service;

@Service
public interface UserRetrieveService {
    //Display User information
    User userDisplayedByID(Long userId) throws NoDataFoundException;

    /**
     * Display User information
     * @param username
     * @return
     */
    User userDisplayedByUserName(String username) throws NoDataFoundException;

    //Delete User
    //Boolean userDeleted(Long userId) throws NoDataFoundException;

    /******************List of Element *************/
    //Display all users information
    List<User> userDisplayedList();

    /**
     * Display users information by page
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map<String, Object> userDisplayedPage(int pageNo, int pageSize);

    // Pour les salons
    //Afficher la liste des salons
    /**
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    Map<String, Object> salonDisplayedPage(int pageNo, int pageSize);
    //Afficher un salon à partir de son id
    /**
     *
     * @param salonId
     * @return
     * @throws NoDataFoundException
     */
    Salon salonDisplayed(long salonId) throws NoDataFoundException;

    //Afficher les coiffeurs d'un salon
    /**
     *
     * @param salonId
     * @return
     * @throws NoDataFoundException
     */
    List<Coiffeur> salonDisplayedCoiffeur(long salonId) throws NoDataFoundException;

    /*********************** Gestion des coiffures **********************************/
    List<Coiffure> salonDisplayedCoiffure(long salonId) throws NoDataFoundException;
    Coiffure coiffureDisplayed(long coiffureId) throws NoDataFoundException;

    /********************** Gestion des carnets ************************************/
    Carnet carnetByCoiffeur(long coiffeurId) throws NoDataFoundException;
    Carnet carnetDisplayed(long carnetId)throws NoDataFoundException;

    /********************* Gestion des plages horaires ******************************/
    List<PlageHoraire> plageHoraireDisplayedList();
    List<PlageHoraire> plageHorairesByCarnet(long carnetId);
    PlageHoraire plageHoraireDisplayed(long plageHoraireId) throws NoDataFoundException;

    //TODO: Afficher les Plage Horaire d'un coiffeur pour une journée x
    List<PlageHoraire>plageHoraireByCoiffeurByJour(Long coiffeurId, Timestamp jour) throws NoDataFoundException;

    //TODO: Reserver une plage horaire

}
