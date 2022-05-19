package com.project.mabarba.service.impl;

import com.project.mabarba.models.Coiffeur;
import com.project.mabarba.models.Salon;
import com.project.mabarba.payload.request.CoiffeurRequest;
import com.project.mabarba.payload.request.SalonRequest;
import com.project.mabarba.repository.CoiffeurRepository;
import com.project.mabarba.repository.SalonRepository;
import com.project.mabarba.service.UpdateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.function.Supplier;

@Service
public class UpdateServiceImpl implements UpdateService {

    @Autowired
    SalonRepository salonRepository;

    @Autowired
    CoiffeurRepository coiffeurRepository;


    @Override
    //Creation d'un salon
    public Salon salonCreation(SalonRequest salonRequest) {
        Supplier<Salon> salon = ()->new Salon(salonRequest.getId(),salonRequest.getNom(), salonRequest.getTelephone());
        return salonRepository.save(salon.get());
    }

    @Override
    //Creation d'un coiffeur
    public Coiffeur barberCreation(CoiffeurRequest coiffeurRequest) {
        Supplier<Coiffeur> coiffeur = ()->new Coiffeur(coiffeurRequest.getId(),coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        return coiffeurRepository.save(coiffeur.get());
    }


    @Override
    //Mise à jour du coiffeur
    public Coiffeur barberModification(CoiffeurRequest coiffeurRequest) {
        Supplier<Coiffeur> coiffeur = ()->new Coiffeur(coiffeurRequest.getId(),coiffeurRequest.getNom(), coiffeurRequest.getTelephone());
        return coiffeurRepository.save(coiffeur.get());
    }

    @Override
    //Mise à jour d'un salon
    public Salon salonModification(SalonRequest salonRequest) {
        Supplier<Salon> salon = ()->new Salon(salonRequest.getId(), salonRequest.getNom(), salonRequest.getTelephone());
        return salonRepository.save(salon.get());
    }



}
