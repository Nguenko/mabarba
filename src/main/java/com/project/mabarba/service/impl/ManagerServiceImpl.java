package com.project.mabarba.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.ManagerRetrieveService;
import com.project.mabarba.service.ManagerUpdateService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ManagerServiceImpl implements ManagerRetrieveService, ManagerUpdateService{
    @Autowired
    SalonRepository salonRepository;

    @Override
    public Salon salonDisplayed(long salonId) throws NoDataFoundException{
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

    /** Update Service implements */
    @Override
    //Creation d'un salon
    public Salon salonCreation(SalonRequest salonRequest) {
        Supplier<Salon> salon = ()->new Salon(salonRequest.getNom(), salonRequest.getTelephone());
        return salonRepository.save(salon.get());
    }

    @Override
    //Mise à jour d'un salon
    public Salon salonModification(SalonRequest salonRequest, Long id) {
        Supplier<Salon> salon = ()->new Salon(id, salonRequest.getNom(), salonRequest.getTelephone());
        return salonRepository.save(salon.get());
    }

    /********************* Coiffeur ****************************/
    @Autowired
    CoiffeurRepository coiffeurRepository;

    /******************* Retrieve Service Implement ******************/
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

    /*********************** Update Service Implements *************/
    @Override
    //Creation d'un coiffeur
    public Coiffeur barberCreation(CoiffeurRequest coiffeurRequest) {
       Supplier<Coiffeur> coiffeur = ()->new Coiffeur(coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
       return coiffeurRepository.save(coiffeur.get());
    }

    @Override
    //Mise à jour du coiffeur
    public Coiffeur barberModification(CoiffeurRequest coiffeurRequest, Long id) {
        Supplier<Coiffeur> coiffeur = ()->new Coiffeur(id,coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        return coiffeurRepository.save(coiffeur.get());
    }
}
