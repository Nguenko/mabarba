package com.project.mabarba.service.impl;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Coiffure;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.CoiffureRequest;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.CoiffureRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.ManagerUpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class ManagerUpdateImpl implements ManagerUpdateService {
    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CoiffeurRepository coiffeurRepository;

    @Autowired
    CoiffureRepository coiffureRepository;

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

    /**
     * Gestion des coiffeurs
     */
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



    /**
     * Gestion des Coiffures
     */
    @Override
    //Creation d'une coiffure
    public Coiffure coiffureCreation(CoiffureRequest coiffureRequest, Long id){
        Coiffure coiffure = new Coiffure(coiffureRequest.getNom(), coiffureRequest.getPrix());
        return coiffureRepository.save(coiffure);
    }

    @Override
    public Coiffure coiffureModification(CoiffureRequest coiffureRequest, Long id) {
        Coiffure coiffure = new Coiffure(id,coiffureRequest.getNom(),coiffureRequest.getPrix());
        return coiffureRepository.save(coiffure);
    }
}
