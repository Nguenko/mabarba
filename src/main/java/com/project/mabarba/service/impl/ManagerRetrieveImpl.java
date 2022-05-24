package com.project.mabarba.service.impl;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Coiffure;
import com.project.mabarba.models.Salon;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.CoiffureRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.ManagerRetrieveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@Service
public class ManagerRetrieveImpl implements ManagerRetrieveService {
    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CoiffeurRepository coiffeurRepository;

    @Autowired
    CoiffureRepository coiffureRepository;

    @Override
    public Salon salonDisplayed(long salonId) throws NoDataFoundException {
        return salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));

    }

    @Override
    public boolean salonDeleted(long salonId) throws NoDataFoundException{
        Salon salon = salonRepository.findByIdAndDeletedIsFalse(salonId).orElseThrow(()->new NoDataFoundException(salonId));
        salon.setDeleted(true);
        salonRepository.save(salon);
        return true;
    }

    @Override
    public List<Salon> salonDisplayedList() {
        Supplier<List<Salon>> salonList = ()->salonRepository.findAllByOrderByCreatedAtDesc();
        return salonList.get();
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

    /**
     * Gestion des coiffeurs
     */
    @Override
    public Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException{
        return   coiffeurRepository.findByIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
    }

    @Override
    public boolean barberDeleted(long coiffeurId) throws NoDataFoundException{
        Coiffeur coiffeur = coiffeurRepository.findByIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
        coiffeur.setDeleted(true);
        coiffeurRepository.save(coiffeur);
        return true;
    }

    @Override
    public List<Coiffeur> barberDisplayedList() {
        Supplier<List<Coiffeur>> coiffeurList = ()->coiffeurRepository.findAllByOrderByCreatedAtDesc();
        return coiffeurList.get();
    }

    @Override
    public Map<String, Object>  barberDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<Coiffeur> barberPage = coiffeurRepository.findAllByOrderByCreatedAtDesc(pageable);
            //on appel la mathode utilitaire qui gere la pagination
            return new FunctionalUtilities<Coiffeur>().paginator(barberPage);
        }catch (Exception e){
            e.getMessage();
        }

        return null;
    }

    /**
     * Gestion des Coiffures
     */

    @Override
    public Coiffure coiffureDisplayed(long coiffureId) throws NoDataFoundException {
        return coiffureRepository.findByIdAndDeletedIsFalse(coiffureId).orElseThrow(()->new NoDataFoundException(coiffureId));
    }

    @Override
    public boolean coiffureDeleted(long coiffureId) throws NoDataFoundException {
        return false;
    }

    @Override
    public List<Coiffure> coiffureDisplayedList() {
        return coiffureRepository.findAllByOrderByCreatedAtDesc();
    }

    @Override
    public Map<String, Object> coiffureDisplayedPage(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        try {
            Page<Coiffure> coiffurePage = coiffureRepository.findAllByOrderByCreatedAtDesc(pageable);
            //on appel la mathode utilitaire qui gere la pagination
            return new FunctionalUtilities<Coiffure>().paginator(coiffurePage);
        }
        catch (Exception e){
            e.getMessage();
        }
        return null;
    }
}
