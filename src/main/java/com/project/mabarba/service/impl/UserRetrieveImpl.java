package com.project.mabarba.service.impl;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.*;
import com.project.mabarba.repository.*;
import com.project.mabarba.service.UserRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Supplier;
import java.util.stream.Collectors;

@Service
public class UserRetrieveImpl implements UserRetrieveService{
    @Autowired
    UserRepository userRepository;
    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CoiffeurRepository coiffeurRepository;

    @Autowired
    CoiffureRepository coiffureRepository;

    @Autowired
    PlageHoraireRepository plageHoraireRepository;

    @Autowired
    CarnetRepository carnetRepository;

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
    public Map<String, Object> salonDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<Salon> salonPage = salonRepository.findAllByOrderByCreatedAtDesc(pageable);
            //on appel la mathode utilitaire qui gere la pagination
            return new FunctionalUtilities<Salon>().paginator(salonPage);
        }catch (Exception e){
            e.getMessage();
        }
        return null;
    }

    @Override
    public Salon salonDisplayed(long salonId) throws NoDataFoundException {
        return salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
    }

    @Override
    public List<Coiffeur> salonDisplayedCoiffeur(long salonId) throws NoDataFoundException {
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        List<Coiffeur> coiffeurList = coiffeurRepository.findBySalonId(salonId);
        return coiffeurList;
    }

    @Override
    public List<Coiffure> salonDisplayedCoiffure(long salonId) throws NoDataFoundException {
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        List<Coiffure> coiffureList = coiffureRepository.findBySalonId(salonId);
        return coiffureList;
    }

    @Override
    public List<PlageHoraire> plageHoraireDisplayedList() {
        List<PlageHoraire> plageHoraireList = plageHoraireRepository.findAllByOrderByCreatedAtDesc();
        return plageHoraireList;
    }

    @Override
    public List<PlageHoraire> plageHoraireByCoiffeurByJour(Long coiffeurId) throws NoDataFoundException{
        Carnet carnet = carnetRepository.findByCoiffeurIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));

        /*List<PlageHoraire> plageHoraireList =
                carnet.getPlageHoraires().stream()
                .filter(plh->plh.getJour().equals(jour))
                .collect(Collectors.toList());*/
        List<PlageHoraire> plageHoraireList = plageHoraireRepository.findAll();

        //plageHoraireList = plageHoraireRepository.findAllByJourAndCarnetIdOrderByCreatedAtDesc(jour,carnet.getId());
        return plageHoraireList;
    }
}
