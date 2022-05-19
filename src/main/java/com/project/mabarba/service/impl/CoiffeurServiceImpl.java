package com.project.mabarba.service.impl;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import com.project.mabarba.exception.NoDataFoundException;
import com.project.mabarba.helpers.FunctionalUtilities;
import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.service.CoiffeurService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class CoiffeurServiceImpl implements CoiffeurService{
    
    @Autowired
    CoiffeurRepository coiffeurRepository;

    /******************* Retrieve Service Implement ******************/
    @Override
    public Coiffeur barberDisplayed(long coiffeurId) throws NoDataFoundException{
        return   coiffeurRepository.findByIdAndDeletedIsFalse(coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
    }

    @Override
    public boolean barberDeleted(long coiffeurId) throws NoDataFoundException{
        Coiffeur coiffeur = coiffeurRepository.deleteCoiffeurById(true,coiffeurId).orElseThrow(()->new NoDataFoundException(coiffeurId));
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
